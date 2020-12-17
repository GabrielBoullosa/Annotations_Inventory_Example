package es.ulpgc.dis;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory(50, 29, 12);

        Class object_class_inventory = inventory.getClass();
        Field[] objects_attributes = object_class_inventory.getDeclaredFields();

        for (Field obj_attr : objects_attributes) {
            final Annotation annotation = obj_attr.getAnnotation(ScrewFactory.class);
            if (annotation != null && annotation instanceof ScrewFactory) {
                final ScrewFactory annotationScrewFactory = (ScrewFactory) annotation;
                Integer value = 0;

                try {
                    obj_attr.setAccessible(true);
                    value = obj_attr.getInt(inventory);
                    obj_attr.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("ANNOTATIONS:" + obj_attr.getName() + ", " + value
                        + ", " + annotationScrewFactory.weight());
            }
        }
    }
}
