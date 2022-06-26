package test.sklearn4j.core.test_template;

import ai.sklearn4j.core.libraries.numpy.NumpyArray;
import ai.sklearn4j.core.libraries.numpy.NumpyArrayFactory;
import ai.sklearn4j.core.packaging.IScikitLearnPackage;
import ai.sklearn4j.preprocessing.label.MultiLabelBinarizer;
import org.junit.jupiter.api.Assertions;
import test.sklearn4j.TestHelper;
import test.sklearn4j.core.test_template.bases.BaseTesterV1;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class MultiLabelBinarizerTesterV1 extends BaseTesterV1 {
    public MultiLabelBinarizer objectUnderTest;

    @Override
    protected String getBinaryFilePath(String version) {
        return String.format("%s/%s/%s/%s/%s_%s.skx", TestHelper.TEST_FILES_HOME, version, scikitLearnVersion, pythonVersion, objectName.toLowerCase().replace(" ", "_"), configurationName.replace(" ", "_"));
    }

    @Override
    protected void performUseCaseSpecificTest(IScikitLearnPackage binaryPackage) {
        objectUnderTest = (MultiLabelBinarizer) binaryPackage.getModel("preprocessing_to_test");

        long[][] transformed = (long[][]) ((NumpyArray)binaryPackage.getExtraValues().get("transformed")).getWrapper().getRawArray();
        Object _raw = binaryPackage.getExtraValues().get("raw");
        List<Object> raw = null;

//        if (_raw instanceof String[]) {
//            raw = Arrays.asList((String[]) _raw);
//        } else {
//            raw = (List<Object>)_raw;
//        }
//
//        MultiLabelBinarizer encoder = (MultiLabelBinarizer) binaryPackage.getModel("preprocessing_to_test");
//
//        NumpyArray<Long> encoderTransformOutput = encoder.transform(raw);
//        TestHelper.assertEqualData(encoderTransformOutput, transformed);
//
//        List<Set<Object>> encoderInverseTransformOutput = encoder.inverseTransform(NumpyArrayFactory.from(transformed));
//        assertEqualData(encoderInverseTransformOutput, raw);
    }

    @Override
    protected void validateExtraValues(IScikitLearnPackage binaryPackage) {

    }

    public static void assertEqualData(List<Object> l1, List<Object> l2) {
        Assertions.assertEquals(l1.size(), l2.size());

        for (int i = 0; i < l1.size(); i++) {
            Assertions.assertEquals(l1.get(i), l2.get(i));
        }
    }
}