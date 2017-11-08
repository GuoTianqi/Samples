package com.gtq.javasample.algorithm;

import java.util.*;

public class BinaryTree {
    public static class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;
    }

    public static interface OnTraverseTreeListener {
        void onTraverse(Node node);
    }

    /**
     *  创建二叉排序树
     *  二叉排序树：左节点值全部小于根节点值，右节点值全部大于根节点值
     *
     *  @param values 数组
     *
     *  @return 二叉树根节点
     */
    public static Node createTree(int[] values) {
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = addTreeNode(root, values[i]);
        }

        return root;
    }

    public static Node addTreeNode(Node parentNode, int value) {
        if (parentNode == null) {
            parentNode = new Node();
            parentNode.value = value;
        }
        // 值小于父节点，  插入左子树
        else if (value < parentNode.value) {
            parentNode.leftChild = addTreeNode(parentNode.leftChild, value);
        }
        // 值大于父节点插入右子树
        else {
            parentNode.rightChild = addTreeNode(parentNode.rightChild, value);
        }

        return parentNode;
    }

    /**
     *  二叉树中某个位置的节点（按层次遍历）
     *
     *  @param rootNode 树根节点
     *  @param index    按层次遍历树时的位置(从0开始算)
     *
     *  @return 节点
     */
    public static Node treeNodeAtIndex(Node rootNode, int index) {
        if (index < 0 || rootNode == null) {
            return null;
        }

        // 先进先出队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(rootNode);
        while (queue.size() > 0) {
            // 取出并删除第一个node
            Node node = queue.removeFirst();
            if (index == 0) {
                return node;
            }

            index--;

            // 压入队列后面
            if (node.leftChild != null) {
                queue.addLast(node.leftChild);
            }

            if (node.rightChild != null) {
                queue.addLast(node.rightChild);
            }
        }

        return null;
    }

    /**
     * 先序遍历
     * 先访问根，再遍历左子树，再遍历右子树。典型的递归思想。
     *
     * @param root
     * @param listener
     */
    public static void preOrderTraverseTree(Node root, OnTraverseTreeListener listener) {
        if (root == null) {
            return;
        }

        if (listener != null) {
            listener.onTraverse(root);
        }

        if (root.leftChild != null) {
            preOrderTraverseTree(root.leftChild, listener);
        }

        if (root.rightChild != null) {
            preOrderTraverseTree(root.rightChild, listener);
        }
    }

    /**
     * 中序遍历
     * 先遍历左子树，再访问根，再遍历右子树。
     * 对于二叉排序树来说，中序遍历得到的序列是一个从小到大排序好的序列。
     *
     * @param root
     * @param listener
     */
    public static void inOrderTraverseTree(Node root, OnTraverseTreeListener listener) {
        if (root == null) {
            return;
        }

        if (root.leftChild != null) {
            inOrderTraverseTree(root.leftChild, listener);
        }

        if (listener != null) {
            listener.onTraverse(root);
        }

        if (root.rightChild != null) {
            inOrderTraverseTree(root.rightChild, listener);
        }
    }

    /**
     *  后序遍历
     *  先遍历左子树，再遍历右子树，再访问根
     *
     * @param root
     * @param listener
     */
    public static void postOrderTraverseTree(Node root, OnTraverseTreeListener listener) {
        if (root == null) {
            return;
        }

        if (root.leftChild != null) {
            postOrderTraverseTree(root.leftChild, listener);
        }

        if (root.rightChild != null) {
            postOrderTraverseTree(root.rightChild, listener);
        }

        if (listener != null) {
            listener.onTraverse(root);
        }
    }


    /**
     * 层次遍历
     * 按照从上到下、从左到右的次序进行遍历。先遍历完一层，再遍历下一层，因此又叫广度优先遍历。
     * @param root
     * @param listener
     */
    public static void levelOrderTraverseTree(Node root, OnTraverseTreeListener listener) {
        if (root == null) {
            return;
        }

        // 先进先出队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while (queue.size() > 0) {
            // 取出并删除第一个node
            Node node = queue.removeFirst();
            if (listener != null) {
                listener.onTraverse(node);
            }

            // 压入队列后面
            if (node.leftChild != null) {
                queue.addLast(node.leftChild);
            }

            if (node.rightChild != null) {
                queue.addLast(node.rightChild);
            }
        }
    }

    /**
     * 二叉树的深度
     * 二叉树的深度定义为：从根节点到叶子结点依次经过的结点形成树的一条路径,最长路径的长度为树的深度。
     * 1）如果根节点为空，则深度为0；
     * 2）如果左右节点都是空，则深度为1；
     * 3）递归思想：二叉树的深度=max（左子树的深度，右子树的深度）+ 1
     *
     * @param root
     * @return
     */
    public static int depthOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }

        int leftDepth = depthOfTree(root.leftChild);
        int rightDepth = depthOfTree(root.rightChild);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 二叉树的宽度
     * 二叉树的宽度定义为各层节点数的最大值
     *
     * @param root
     */
    public static int widthOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);

        int maxWidth = 1;
        int curWidth = 0;

        while (queue.size() > 0) {
            curWidth = queue.size();
            for (int i = 0; i < curWidth; i++) {
                Node node = queue.removeFirst();
                if (node.leftChild != null) {
                    queue.addLast(node.leftChild);
                }
                if (node.rightChild != null) {
                    queue.addLast(node.rightChild);
                }
            }

            maxWidth = Math.max(maxWidth, curWidth);
        }

        return maxWidth;
    }

    /**
     * 二叉树的所有节点数
     * 递归思想：二叉树所有节点数=左子树节点数+右子树节点数+1
     *
     * @param root
     * @return
     */
    public static int treeNodeCount(Node root) {
        if (root == null) {
            return 0;
        }

        return treeNodeCount(root.leftChild) + treeNodeCount(root.rightChild) + 1;
    }

    public static void main(String[] args) {
        int length = 10;
        int[] values = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            values[i] = random.nextInt(1000);
        }

        values = new int[] {
                769, 521, 908, 276, 605, 93, 756, 163, 436, 347
        };

        System.out.println("values = " + Arrays.toString(values));

        Node root = createTree(values);

        int index = 7;
        Node node = treeNodeAtIndex(root, index);
        System.out.println("value at " + index + ": " + (node == null ? null : node.value));

        System.out.println("先序遍历:");
        preOrderTraverseTree(root, node1 -> System.out.print(node1.value + " "));

        System.out.println("\n中序遍历:");
        inOrderTraverseTree(root, node1 -> System.out.print(node1.value + " "));

        System.out.println("\n后序遍历:");
        postOrderTraverseTree(root, node1 -> System.out.print(node1.value + " "));

        System.out.println("\n层次遍历（广度优先）:");
        levelOrderTraverseTree(root, node1 -> System.out.print(node1.value + " "));

        System.out.println("\n树深度: " + depthOfTree(root));
        System.out.println("\n树宽度: " + widthOfTree(root));
        System.out.println("\n节点数: " + treeNodeCount(root));
    }
}
