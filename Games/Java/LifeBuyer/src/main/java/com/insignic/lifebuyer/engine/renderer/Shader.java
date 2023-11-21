package com.insignic.lifebuyer.engine.renderer;

import com.insignic.lifebuyer.utils.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;

public class Shader {

    private int shaderProgramId;
    private String vertexSource;
    private String fragmentSource;
    private String filePath;

    public Shader(String filePath){

        this.filePath = filePath;

        try {

            // Find first pattern after #type
            String source = new String(Files.readAllBytes(Paths.get(filePath)));
            String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");
            int index = source.indexOf("#type") + 6;
            int eol = source.indexOf("\r\n", index);
            String firstPattern = source.substring(index, eol).trim();

            // Find second pattern after #type
            index = source.indexOf("#type", eol) + 6;
            eol = source.indexOf("\r\n", index);
            String secondPattern = source.substring(index, eol).trim();

            if(firstPattern.equals("vertex")){

                vertexSource = splitString[1];

            } else if(firstPattern.equals("fragment")) {

                fragmentSource = splitString[1];

            } else {

                throw new IOException("Error, unexpected token : '" + firstPattern + "' !");

            }

            if(secondPattern.equals("vertex")){

                vertexSource = splitString[2];

            } else if(secondPattern.equals("fragment")) {

                fragmentSource = splitString[2];

            } else {

                throw new IOException("Error, unexpected token : '" + secondPattern + "' !");

            }

        } catch(IOException e){

            e.printStackTrace();
            assert false : "Error, couldn't open file for shader : '" + filePath + "' !";

        }

    }

    public void compile(){

        //############################################
        //         Compile and Link Shaders
        //############################################

        int vertexId, fragmentId;

        // Load and compile vertex shader.
        vertexId = glCreateShader(GL_VERTEX_SHADER);

        // Pass shader source code to GPU
        glShaderSource(vertexId, vertexSource);
        glCompileShader(vertexId);

        // Check for errors in compilation
        int succes = glGetShaderi(vertexId, GL_COMPILE_STATUS);

        if(succes == GL_FALSE){

            int lenght = glGetShaderi(vertexId, GL_INFO_LOG_LENGTH);
            Logger.error("'" + filePath + "':\n\tVertex shader compilation failed !");
            Logger.error(glGetShaderInfoLog(vertexId, lenght));
            assert false : "";

        }

        // Load and compile Fragment shader.
        fragmentId = glCreateShader(GL_FRAGMENT_SHADER);

        // Pass shader source code to GPU
        glShaderSource(fragmentId, fragmentSource);
        glCompileShader(fragmentId);

        // Check for errors in compilation
        succes = glGetShaderi(fragmentId, GL_COMPILE_STATUS);

        if(succes == GL_FALSE){

            int lenght = glGetShaderi(vertexId, GL_INFO_LOG_LENGTH);
            Logger.error("'" + filePath + "':\n\tFragment shader compilation failed !");
            Logger.error(glGetShaderInfoLog(vertexId, lenght));
            assert false : "";

        }

        // Link shaders
        shaderProgramId = glCreateProgram();
        glAttachShader(shaderProgramId, vertexId);
        glAttachShader(shaderProgramId, fragmentId);
        glLinkProgram(shaderProgramId);

        // Check linking errors
        succes = glGetProgrami(shaderProgramId, GL_LINK_STATUS);

        if(succes == GL_FALSE){

            int lenght = glGetProgrami(shaderProgramId, GL_INFO_LOG_LENGTH);
            Logger.error("'" + filePath + "':\n\tLinking of shaders failed !");
            Logger.error(glGetProgramInfoLog(shaderProgramId, lenght));
            assert false : "";

        }

    }

    public void use(){

        // Bind shader program
        glUseProgram(shaderProgramId);

    }

    public void detach(){

        glUseProgram(0);

    }

}
