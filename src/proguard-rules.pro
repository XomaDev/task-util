# Add any ProGuard configurations specific to this
# extension here.

-keep public class xyz.kumaraswamy.taskutil.TaskUtil {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'xyz/kumaraswamy/taskutil/repack'
-flattenpackagehierarchy
-dontpreverify
