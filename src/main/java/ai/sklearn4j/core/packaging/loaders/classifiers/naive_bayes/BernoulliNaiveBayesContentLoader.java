package ai.sklearn4j.core.packaging.loaders.classifiers.naive_bayes;

import ai.sklearn4j.core.libraries.numpy.NumpyArray;
import ai.sklearn4j.core.packaging.loaders.BaseScikitLearnContentLoader;
import ai.sklearn4j.core.packaging.loaders.IScikitLearnContentLoader;
import ai.sklearn4j.naive_bayes.BernoulliNaiveBayes;

/**
 * BernoulliNaiveBayes object loader.
 */
public class BernoulliNaiveBayesContentLoader extends BaseScikitLearnContentLoader<BernoulliNaiveBayes> {
    /**
     * Instantiate a new object of BernoulliNaiveBayesContentLoader.
     */
    public BernoulliNaiveBayesContentLoader() {
        super("nb_bernoulli_serializer");
    }

    /**
     * Instantiate an unloaded BernoulliNaiveBayes classifier.
     *
     * @return The unloaded classifier.
     */
    @Override
    protected BernoulliNaiveBayes createResultObject() {
        return new BernoulliNaiveBayes();
    }

    /**
     * Create a clean instance of the loader.
     *
     * @return A clean instance of the loader.
     */
    @Override
    public IScikitLearnContentLoader duplicate() {
        return new BernoulliNaiveBayesContentLoader();
    }

    /**
     * Defines the fields that are required to initialize a trained classifier.
     */
    @Override
    protected void registerSetters() {
        registerNumpyArrayField("classes_", this::setClasses);
        registerNumpyArrayField("class_count_", this::setClassCount);
        registerNumpyArrayField("class_log_prior_", this::setClassLogPriors);
        registerNumpyArrayField("feature_log_prob_", this::setFeatureLogProbabilities);
        registerNumpyArrayField("feature_count_", this::setFeatureCount);
        registerDoubleField("binarize", this::setBinarization);
    }

    /**
     * Sets the binarization to be performed on the data.
     *
     * @param result The classifier to be loaded.
     * @param value  The binarization threshold.
     */
    private void setBinarization(BernoulliNaiveBayes result, double value) {
        result.setBinarizationThreshold(value);
    }

    /**
     * Sets the feature's log probability in the training data.
     *
     * @param result     The classifier to be loaded.
     * @param numpyArray The feature's log probability in the training data.
     */
    private void setFeatureLogProbabilities(BernoulliNaiveBayes result, NumpyArray numpyArray) {
        result.setFeatureLogProbabilities(numpyArray);
    }

    /**
     * Sets the frequency of the features in the training data.
     *
     * @param result     The classifier to be loaded.
     * @param numpyArray The frequency of the features in the training data.
     */
    private void setFeatureCount(BernoulliNaiveBayes result, NumpyArray numpyArray) {
        result.setFeatureCount(numpyArray);
    }

    /**
     * Sets the probability of each class.
     *
     * @param result The classifier to be loaded.
     * @param value  The probability of each class.
     */
    private void setClassLogPriors(BernoulliNaiveBayes result, NumpyArray value) {
        result.setClassLogPrior(value);
    }

    /**
     * Sets the class labels known to the classifier.
     *
     * @param result The classifier to be loaded.
     * @param value  The class labels known to the classifier.
     */
    private void setClasses(BernoulliNaiveBayes result, NumpyArray value) {
        result.setClasses(value);
    }

    /**
     * Sets the number of training samples observed in each class.
     *
     * @param result The classifier to be loaded.
     * @param value  The number of training samples observed in each class.
     */
    private void setClassCount(BernoulliNaiveBayes result, NumpyArray value) {
        result.setClassCounts(value);
    }
}