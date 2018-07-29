package com.dj.ch11_2048;

import java.awt.Color;
import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;
/**
ģ��2048С��Ϸ��</br>
 ��Ϸ���򣺻�����Ļ���ƶ�С���飬��������һ����С������ײʱ�ͻ���Ӻϳ�һ�����飬
ÿ�β���֮����ڿհ׵ķ����������һ��2��4�ķ��飬���յõ�һ��2048�ķ������ʤ���ˣ�
���16������ȫ�������޷��ƶ��Ļ�GAMEOVER��
* */
public class Game2048 extends JPanel {
/**������ɫ*/
static Color BG_COLOR = new Color(0xbbada0);
/**����*/
static String FONT_NAME = "Arial";
/**��������(���)*/
static int BLOCK_SIZE = 64;
/**����֮��������*/
static int BLOCKS_MARGIN = 16;
static int MOVE_TIME = 80;
static int MOVE_TIMES = 20;

static int ENLARGE_SIZE = 15;
static int ENLARGE_TIME = 50;
static int ENLARGE_TIMES = 10;
////�Ƿ�Ӯ���䡢�ƶ����ϲ�
boolean isWin,isLose,move,merge;
//��������
boolean animateOver = true;
//�ƶ�ǰ�����飬��һ���ƶ���Ľ������
Block[][] blocks,resultBlocks;

Image image;
//���������ֵ
int max;
//����������ĺ����ꡢ������
int score,xx,yy;
//�ƶ����ϲ����񼯺�
public List<Block> moveList;
public List<Block> mergeList;

public static void main(String[] args) {
	new Game2048();
}
}
