/*
 * This file was automatically generated, don't edit it manually.
 */

package ai.sklearn4j.core.libraries.numpy.wrappers;

import ai.sklearn4j.core.libraries.numpy.INumpyArrayWrapper;
import ai.sklearn4j.core.libraries.numpy.NumpyArray;
import ai.sklearn4j.core.libraries.numpy.NumpyArrayFactory;
import ai.sklearn4j.core.libraries.numpy.NumpyOperationException;


/**
 * A wrapper over a 6 dimensions int array for NumpyArray class.
 */
public class Dim6Int32NumpyWrapper implements INumpyArrayWrapper {
    private final int[][][][][][] array;
    private final int[] shape;

    /**
     * Instantiate a new wrapper for 6 array.
     *
     * @param array The underlying native array object.
     */
    public Dim6Int32NumpyWrapper(int[][][][][][] array) {
        this.array = array;
        this.shape = new int[]{array.length, array[0].length, array[0][0].length, array[0][0][0].length, array[0][0][0][0].length, array[0][0][0][0][0].length};
    }

    @Override
    public int[] getShape() {
        return shape;
    }

    @Override
    public Object get(int... indices) {
        return array[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]];
    }

    @Override
    public void set(Object value, int... indices) {
        this.array[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]][indices[5]] = NumpyArrayFactory.toInteger(value);
    }

    /**
     * Gets the underlying native array object.
     *
     * @return The underlying native array object.
     */
    public int[][][][][][] getArray() {
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
        } else if (indices.length == 2) {
            result = NumpyArrayFactory.from(array[indices[0]][indices[1]]);
        } else if (indices.length == 3) {
            result = NumpyArrayFactory.from(array[indices[0]][indices[1]][indices[2]]);
        } else if (indices.length == 4) {
            result = NumpyArrayFactory.from(array[indices[0]][indices[1]][indices[2]][indices[3]]);
        } else if (indices.length == 5) {
            result = NumpyArrayFactory.from(array[indices[0]][indices[1]][indices[2]][indices[3]][indices[4]]);
        } else {
            throw new NumpyOperationException("Invalid slice for array specified.");
        }

        return result;
    }


    @Override
    public NumpyArray transpose() {
        int[][][][][][] result = new int[shape[5]][shape[4]][shape[3]][shape[2]][shape[1]][shape[0]];

        for (int d0 = 0; d0 < this.shape[0]; d0++) {
            for (int d1 = 0; d1 < this.shape[1]; d1++) {
                for (int d2 = 0; d2 < this.shape[2]; d2++) {
                    for (int d3 = 0; d3 < this.shape[3]; d3++) {
                        for (int d4 = 0; d4 < this.shape[4]; d4++) {
                            for (int d5 = 0; d5 < this.shape[5]; d5++) {
                                result[d5][d4][d3][d2][d1][d0] = array[d0][d1][d2][d3][d4][d5];

                            }
                        }
                    }
                }
            }
        }

        return NumpyArrayFactory.from(result);
    }
}