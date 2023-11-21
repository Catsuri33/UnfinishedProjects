package com.insignic.lifebuyer.engine.scenes;

import com.insignic.lifebuyer.engine.renderer.Shader;
import com.insignic.lifebuyer.utils.Logger;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class LevelEditorScene extends Scene {

    private String vertexShaderSrc = "#version 330 core\n" +
            "layout (location = 0) in vec3 aPos;\n" +
            "layout (location = 1) in vec4 aColor;\n" +
            "\n" +
            "out vec4 fColor;\n" +
            "\n" +
            "void main(){\n" +
            "\n" +
            "    fColor = aColor;\n" +
            "    gl_Position = vec4(aPos, 1.0);\n" +
            "\n" +
            "}";
    private String fragmentShaderSrc = "#version 330 core\n" +
            "\n" +
            "in vec4 fColor;\n" +
            "\n" +
            "out vec4 color;\n" +
            "\n" +
            "void main(){\n" +
            "\n" +
            "    color = fColor;\n" +
            "\n" +
            "}";
    private int vertexId, fragmentId, shaderProgram;
    private float[] vertexArray = {

        // Postion              Color
        0.5f, -0.5f, 0.0f,      1.0f, 0.0f, 0.0f, 1.0f, // Bottom Right Corner 0
        -0.5f, 0.5f, 0.0f,      0.0f, 1.0f, 0.0f, 1.0f, // Top Left Corner     1
        0.5f, 0.5f, 0.0f,      0.0f, 0.0f, 1.0f, 1.0f, // Top Right Corner      2
        -0.5f, -0.5f, 0.0f,      1.0f, 1.0f, 0.0f, 1.0f // Bottom Left Corner  3

    };
    private int[] elementArray = {

        2, 1, 0, // Top Right Triangle
        0, 1, 3 // Bottom Left Triangle

    };
    private int vaoId, vboId, eboId;
    private Shader defaultShader;

    public LevelEditorScene(){



    }

    @Override
    public void init(){

        defaultShader = new Shader("assets/shaders/default.glsl");
        defaultShader.compile();

        //############################################
        //              VAO, VBO, EBO
        //############################################
        vaoId = glGenVertexArrays();
        glBindVertexArray(vaoId);

        // Create float buffer of vertices
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(vertexArray.length);
        vertexBuffer.put(vertexArray).flip();

        // Create VBO and upload vertex buffer
        vboId = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboId);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);

        // Create indices and upload
        IntBuffer elementBuffer = BufferUtils.createIntBuffer(elementArray.length);
        elementBuffer.put(elementArray).flip();

        eboId = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboId);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, elementBuffer, GL_STATIC_DRAW);

        // Add vertex attributes pointers
        int positionSize = 3;
        int colorSize = 4;
        int floatSizeBytes = 4;
        int vertexSizeBytes = (positionSize + colorSize) * floatSizeBytes;

        glVertexAttribPointer(0, positionSize, GL_FLOAT, false, vertexSizeBytes, 0);
        glEnableVertexAttribArray(0);

        glVertexAttribPointer(1, colorSize, GL_FLOAT, false, vertexSizeBytes, positionSize * floatSizeBytes);
        glEnableVertexAttribArray(1);

    }

    @Override
    public void update(float dt) {

        defaultShader.use();
        //Bind the VAO
        glBindVertexArray(vaoId);
        // Enable vertex attributes pointers
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);

        glDrawElements(GL_TRIANGLES, elementArray.length, GL_UNSIGNED_INT, 0);

        // Unbind everything
        glDisableVertexAttribArray(0);
        glDisableVertexAttribArray(1);

        glBindVertexArray(0);

        defaultShader.detach();

    }

}
