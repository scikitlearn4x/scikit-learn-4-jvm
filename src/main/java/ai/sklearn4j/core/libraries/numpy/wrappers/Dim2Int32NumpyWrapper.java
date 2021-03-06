/*
 * This file was automatically generated, don't edit it manually.
 */

package ai.sklearn4j.core.libraries.numpy.wrappers;

import ai.sklearn4j.core.libraries.numpy.INumpyArrayWrapper;
import ai.sklearn4j.core.libraries.numpy.NumpyArray;
import ai.sklearn4j.core.libraries.numpy.NumpyArrayFactory;
import ai.sklearn4j.core.libraries.numpy.NumpyOperationException;


/**
 * A wrapper over a 2 dimensions int array for NumpyArray class.
 */
public class Dim2Int32NumpyWrapper implements INumpyArrayWrapper {
    private final int[][] array;
    private final int[] shape;

    /**
     * Instantiate a new wrapper for 2 array.
     *
     * @param array The underlying native array object.
     */
    public Dim2Int32NumpyWrapper(int[][] array) {
        this.array = array;
        this.shape = new int[]{array.length, array[0].length};
    }

    @Override
    public int[] getShape() {
        return shape;
    }

    @Override
    public Object get(int... indices) {
        return array[indices[0]][indices[1]];
    }

    @Override
    public void set(Object value, int... indices) {
        this.array[indices[0]][indices[1]] = NumpyArrayFactory.toInteger(value);
    }

    /**
     * Gets the underlying native array object.
     *
     * @return The underlying native array object.
     */
    public int[][] getArray() {
        return this.array;
    }

    @Override
    public boolean isFloatingPoint() {
        return false;
    }


    @Override
    public int numberOfBits() {
        return 32;
    }


    @Override
    public Object getRawArray() {
        return array;
    }


    @Override
    public NumpyArray wrapInnerSubsetArray(int... indices) {
        NumpyArray result = null;

        if (indices.length == 1) {
            result = NumpyArrayFactory.from(array[indices[0]]);
        } else {
            throw new NumpyOperationException("Invalid slice for array specified.");
        }

        return result;
    }


    @Override
    public NumpyArray transpose() {
        int[][] result = new int[shape[1]][shape[0]];

        for (int d0 = 0; d0 < this.shape[0]; d0++) {
            for (int d1 = 0; d1 < this.shape[1]; d1++) {
                result[d1][d0] = array[d0][d1];

            }
        }

        return NumpyArrayFactory.from(result);
    }
}