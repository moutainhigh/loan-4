package com.aoying.loan.common.util;

public class RmbConvert
{
  /**
   *人民币的基本信息和操作
   *@author weinee
   *@version 1.0
  */
  private static String[] hanArr = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };//汉字计数符号
  private static String[] unitArr = {"", "拾", "佰", "仟"};//汉字计数单位
  private static String[] unitArrs = {"万", "亿", "万", "兆", "万", "亿", "万", ""}; //顺序添加单位

  
  /**
   *把一个浮点数分解成long型部分和小数部分字符串，把人民币换成了整数，浮点数在取小数部分时临界值有误差
   *@return 返回分解后的字符串数组，第一个数组元素是整数部分，第二个是小数部分字符串
  */
  private static String[] divideNum(double number){
    double num = Math.round(number*100);//对number进行四舍五入取整
    long integerPart = (long)num; //连同小数点后两位取成整数 ，避免使用减法
    //double decimalsPart = num-integerPart;//小数部分，临界时产生了误差
    String decimalsPartStr;
    long b = integerPart % 10; //小数点后第二位
    long a = (integerPart/10) % 10;//小数点后第一位
    integerPart /= 100;
    if(a==0 && b==0){
      decimalsPartStr = null;
    }else{
      decimalsPartStr = "" + a + b;
    }
    return new String[] {String.valueOf(integerPart) , decimalsPartStr};
  }
  
  /**
   *把一个数字字符转换成汉语的人民币读法
   *@return 返回汉语人民币读法的字符串形式
  */
  public static String toHanStr(double number){
    String[] results = new String[9]; //用来暂时存储每四位分段后的数字字符串
    String[] resultStrs = new String[9];//用来暂时存储每四位分段后转换成的人民币读法
    String result = "";//最终的转换结果
    String[] divideStr = divideNum(number); //得到浮点数分解成的long型部分和小数部分字符串，第一个数组元素是整数部分字符串，第二个是小数部分字符串
    results[8] = divideStr[1];
    for (int i=divideStr[0].length(), j=8; i>0&&j>0 ; i-=4,j--){
      try{
        results[j-1] = divideStr[0].substring(i-4, i);
      }catch(Exception e){
        results[j-1] = divideStr[0].substring(0, i);
        break;
      }
    } 
    if(results[8] == null){
      resultStrs[8] = "";
    }else if(results[8].charAt(1) == '0'){
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "角"; //根据ASCII码和hanArr数组吧数字改成汉语大写
    }else{
      resultStrs[8] = hanArr[results[8].charAt(0) - 48] + "角" + hanArr[results[8].charAt(1) - 48] + "分"; 
    }
    for(int i=0; i<8; i++){
      if(results[i] != null){
        resultStrs[i] = "";
        resultStrs[i] += hanArr[results[i].charAt(0) - 48] + unitArr[results[i].length() - 1]; //根据ASCII码和数组长度选择数的单位
        for (int j=1; j<results[i].length(); j++ )
          if(results[i].charAt(j-1) == '0' && results[i].charAt(j) != '0')
            resultStrs[i] += "零" + hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];  //根据ASCII码和数组长度选择数的单位
          else if(results[i].charAt(j) != '0' )
            resultStrs[i] += hanArr[results[i].charAt(j) - 48] + unitArr[results[i].length() - 1 - j];
      }
    }
    for (int i=0; i<8; i++ ){
      if(resultStrs[i] != null){
        result += resultStrs[i] + unitArrs[i];
      }
    }
    result += resultStrs[8];
    return result;
  }
}