package recursion;

/**
 * Created by 22643 on 2020/4/8.
 */
public class MiGong {
    public static void main(String[] args) {
        //创建二维数组模拟,模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //将第一行和最后一行置为一
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;//1是墙
            map[7][i] = 1;
        }
        //将左边第一列和右边第一列值为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        System.out.println("迷宫的样子");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();

        }
//使用递归回溯给小球找路
        setWay(map, 1, 1);
        //输出新的地图,小球走过并表示过的地图/
        System.out.println("迷宫的样子");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();

        }
    }
    //使用递归回溯来个小球找路
//说明map表示地图,
    //2.i,j表示从地图的哪个位置开始出发
    //3.如果小球能到map[6][5],则说明通路找到
    //约定:当map[i][j]还没有走过
    //当map[i][j]=1是墙
    //再走迷宫时,需要确定一个策略(方法)先走下面,走不通走右边再走不通做上在走不通走左,该点走不通,再回漱


    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路就返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个节点还没有走过
                //按照策略下右上左

                map[i][j] = 2;//假定该店是可以走通的
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//上
                    return true;
                } else if (setWay(map, i, j - 1)) {//左
                    return true;
                } else {
                    //说明该点是走不通的
                    map[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j]!=0说明是1,2,3.1墙,2走过了,3死路
                return false;
            }
        }
    }
    //修改过的方法
//    public static boolean setWay(int[][] map, int i, int j) {
//        if (map[6][5] == 2) {//通路已经找到
//            return true;
//        } else {
//            if (map[i][j] == 0) {//如果当前这个节点还没有走过
//                //按照策略下右上左
//
//                map[i][j] = 2;//假定该店是可以走通的
//                if (setWay(map, i + 1, j)) {//向下走
//                    return true;
//                } else if (setWay(map, i, j + 1)) {//向右走
//                    return true;
//                } else if (setWay(map, i - 1, j)) {//上
//                    return true;
//                } else if (setWay(map, i, j - 1)) {//左
//                    return true;
//                } else {
//                    //说明该点是走不通的
//                    map[i][j] = 3;
//                    return false;
//                }
//            } else { //如果map[i][j]!=0说明是1,2,3.1墙,2走过了,3死路
//                return false;
//            }
//        }
//    }
}
