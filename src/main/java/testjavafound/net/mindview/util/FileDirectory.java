package main.java.testjavafound.net.mindview.util;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public final class FileDirectory {
    public static File[]
    local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(
                        new File(name).getName()).matches();
            }
        });
    }
    public static File[]
    local(String path, final String regex) { // Overloaded
        return local(new File(path), regex);
    }
    // A two-tuple for returning a pair of objects:
    public static class TreeInfo implements Iterable<File> {
        // 输出标记
        // 输出所有
        public static final Integer PRING_FLAGE_ALL = 01;
        // 输出目录
        public static final Integer PRING_FLAGE_DIRS = 02;
        // 输出文件
        public static final Integer PRING_FLAGE_FILES = 03;
        // 输出树形结构
        public static final Integer PRING_FLAGE_TREE = 04;

        // 输出方式
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        public List<Object> tree = new ArrayList<>();

        // The default iterable element is the file list:
        public Iterator<File> iterator() {
            return files.iterator();
        }
        public void addSelect(final Integer pringFlag,File file, String regex,TreeInfo treeInfo) {
            switch (pringFlag) {
                case 01:
                    treeInfo.dirs.add(file);
                    treeInfo.addAll(recurseDirs(pringFlag,file, regex));
                    break;
                case 02:
                    treeInfo.dirs.add(file);
                    treeInfo.addAllDirs(recurseDirs(pringFlag,file, regex));
                    break;
                case 03:
                    treeInfo.addAll(recurseDirs(pringFlag,file, regex));
                    break;
                case 04:
                    treeInfo.tree.add(file);
                    treeInfo.addAllTree(treeInfo,recurseDirs(pringFlag,file, regex));
                    break;
                default:
                    break;
            }
        }
        void addAll(TreeInfo other) {
            files.addAll(other.files);
            // 想用同一个list
            dirs.addAll(other.dirs);
        }
        void addAllDirs(TreeInfo other) {
            // 想用同一个list
            dirs.addAll(other.dirs);
        }
        void addAllTree(TreeInfo treeInfo,TreeInfo other) {
            List<Object> files = new ArrayList<>();
            boolean b = files.addAll(other.tree);
            if (b)
            // 想用同一个list
            treeInfo.tree.addAll(files);
        }
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
        public String toString(final Integer pringFlag) {
            String pr = null;
            switch (pringFlag) {
                case 01: pr = "dirs: " + PPrint.pformat(dirs) +
                        "\n\nfiles: " + PPrint.pformat(files);
                    break;
                case 02: pr = "dirs: " + PPrint.pformat(dirs);
                    break;
                case 03: pr = "files: " + PPrint.pformat(files);
                    break;
                case 04: pr = "tree: " + tree;
                    break;
                default: break;
            }
            if (pr == null) {
                pr = "没有输出内容";
            }
            return pr;
        }
    }
    public static TreeInfo
    walk(final Integer pringFlag,String start, String regex) { // Begin recursion
        return recurseDirs(pringFlag,new File(start), regex);
    }
    public static TreeInfo
    walk(final Integer pringFlag,File start, String regex) { // Overloaded
        return recurseDirs(pringFlag,start, regex);
    }
    public static TreeInfo walk(final Integer pringFlag,File start) { // Everything
        return recurseDirs(pringFlag,start, ".*");
    }
    public static TreeInfo walk(final Integer pringFlag,String start) {
        return recurseDirs(pringFlag,new File(start), ".*");
    }
    static TreeInfo recurseDirs(final Integer pringFlag,File startDir, String regex){
        TreeInfo result = new TreeInfo();
        for(File item : startDir.listFiles()) {
            if(item.isDirectory()) {
//                result.dirs.add(item);
//                result.addAll(recurseDirs(item, regex));
                result.addSelect(pringFlag,item,regex,result);
            } else // Regular file
                if(item.getName().matches(regex))
                    result.files.add(item);
        }
        return result;
    }
    // Simple validation test:
    public static void main(String[] args) {
        if(args.length == 0)
            System.out.println(walk(TreeInfo.PRING_FLAGE_TREE,".").toString(TreeInfo.PRING_FLAGE_TREE));
//            walk(TreeInfo.PRING_FLAGE_FILES,".");
        else
            for(String arg : args)
                System.out.println(walk(TreeInfo.PRING_FLAGE_ALL,arg));
    }
}

// 目录字段
class FileName {
    private String id;
    private Object children;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FileName{" +
                "id='" + id + '\'' +
                ", children=" + children +
                ", name='" + name + '\'' +
                '}';
    }
}
