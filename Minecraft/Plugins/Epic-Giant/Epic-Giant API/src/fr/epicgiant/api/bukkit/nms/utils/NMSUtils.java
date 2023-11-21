package fr.epicgiant.api.bukkit.nms.utils;

import net.minecraft.server.v1_14_R1.BiomeBase;
import net.minecraft.server.v1_14_R1.EntityInsentient;
import net.minecraft.server.v1_14_R1.EntityTypes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NMSUtils {

    public static void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass){

        try {
            List<Map<?, ?>> dataMaps = new ArrayList<Map<?, ?>>();
            for(Field field : EntityTypes.class.getDeclaredFields()){
                if(field.getType().getSimpleName().equals(Map.class.getSimpleName())){
                    field.setAccessible(true);
                    dataMaps.add((Map<?, ?>) field.get(null));
                }
            }
            if(dataMaps.get(0).containsKey(id)){
                dataMaps.get(0).remove(name);
                dataMaps.get(2).remove(id);
            }

            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, customClass, name, id);

            for(Field field : BiomeBase.class.getDeclaredFields()){
                if(field.getType().getSimpleName().equals(List.class.getSimpleName())){
                    if(field.get(null) != null){
                        for(Field list : BiomeBase.class.getDeclaredFields()){
                            if(list.getType().getSimpleName().equals(List.class.getSimpleName())){
                                list.setAccessible(true);
                                List<BiomeBase.BiomeMeta> metaList = (List<BiomeBase.BiomeMeta>) list.get(field.get(null));

                                for(BiomeBase.BiomeMeta meta : metaList){
                                    Field classe = BiomeBase.BiomeMeta.class.getDeclaredFields()[0];
                                    if(classe.get(meta).equals(nmsClass)){
                                        classe.set(meta, customClass);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
