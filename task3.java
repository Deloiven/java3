String str = "string";
void modString(){
    str = str.substring(0, str.length() - 1);
    System.out.println(str);
}