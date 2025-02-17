/*
 *  Copyright (c) Ramesh Babu Prudhvi.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.github.selcukes.databind.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * > Reflections is a class that provides a way to get a list of all the classes
 * in a package
 */
@UtilityClass
public class Reflections {
    @SuppressWarnings("all")
    // Creating a new instance of the class passed to it.
    public <T> T newInstance(final Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            if ((!Modifier.isPublic(constructor.getModifiers()) ||
                    !Modifier.isPublic(constructor.getDeclaringClass().getModifiers())) &&
                    !constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    @SuppressWarnings("all")
    // Creating a new instance of the class passed to it.
    public static <T> T newInstance(final Class<T> clazz, final Object... initArgs) {
        try {
            return (T) clazz.getConstructors()[0].newInstance(initArgs);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @SuppressWarnings("squid:S3011")
    // Setting the value of the field in the object.
    public static void setField(final Object object, final String fieldName, final Object value) {
        try {
            Class<?> clazz = object == null ? Object.class : object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    @SuppressWarnings("squid:S3011")
    // Getting the method from the class.
    public static <T> Method getDeclaredMethod(Class<T> clazz, String name, Class<?>... param) {
        try {
            Method method = clazz.getDeclaredMethod(name, param);
            method.setAccessible(true);
            return method;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @SneakyThrows
    // Invoking a static method on a class.
    public static void invoke(final Class<?> clazz, final String methodName, final String param) {
        Method method = clazz.getMethod(methodName, String.class);
        method.invoke(null, param);
    }
}
