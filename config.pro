-injars weaponsarray.jar
-outjars weaponsarray_release.jar

-libraryjars /usr/lib/jvm/java-7-openjdk-amd64/jre/lib/rt.jar
-libraryjars /usr/lib/jvm/java-7-openjdk-i386/jre/lib/rt.jar



-keep public class vafspy.weparr.mainPass {
    public static void main(java.lang.String[]);
}
