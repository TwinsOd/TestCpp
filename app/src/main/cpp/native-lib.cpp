#include <jni.h>
#include <string>
#include <opencv2/core.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/features2d.hpp>
#include <vector>

extern "C" {
jstring
Java_com_twinsod_testcpp_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


jstring

Java_com_twinsod_testcpp_MainActivity_validate(
        JNIEnv *env,
        jobject,
        jlong addrGray, jlong addrRgba) {
    cv::Rect();
    cv::Mat();
    std::string hello2 = "Hello from validate";
    return env->NewStringUTF(hello2.c_str());
}

JNIEXPORT void JNICALL Java_com_twinsod_testcpp_Tutorial2Activity_FindFeatures(JNIEnv*, jobject, jlong addrGray, jlong addrRgba)
{
    cv::Mat& mGr  = *(cv::Mat*)addrGray;
    cv::Mat& mRgb = *(cv::Mat*)addrRgba;
    std::vector<cv::KeyPoint> v;

    cv::Ptr<cv::FeatureDetector> detector = cv::FastFeatureDetector::create(50);
    detector->detect(mGr, v);
    for( unsigned int i = 0; i < v.size(); i++ )
    {
        const cv::KeyPoint& kp = v[i];
        circle(mRgb, cv::Point(kp.pt.x, kp.pt.y), 10, cv::Scalar(255,0,0,255));
    }
}
}

