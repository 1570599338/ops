package com.lquan.ops.util.constant;

import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class StringUtil {


    private StringUtil() {
    }

    public static final boolean isEmpty(String str) {
        return str == null || str.trim().length() < 1;
    }

    public static final boolean notEmpty(String str) {
        return str != null && str.trim().length() >= 1;
    }

    public static String nullToString(Object o) {
        String s = "";
        return o != null?String.valueOf(o):s;
    }

    private static String trim(String s, boolean isTransferred) {
        return isTransferred?(s == null?"":s.trim()):(s == null?"":s.trim());
    }

    public static String trim(String s) {
        return trim(s, false);
    }

    public static String encode(String arg) {
        try {
            return URLEncoder.encode(arg, "utf-8");
        } catch (Exception var2) {
            log.error(var2.getMessage(), var2);
            return trim(arg, true);
        }
    }

    public static String decode(String arg) {
        try {
            return URLDecoder.decode(arg, "utf-8");
        } catch (Exception var2) {
            log.error(var2.getMessage(), var2);
            return trim(arg, true);
        }
    }

    public static String escape(String str) {
        if(str == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.ensureCapacity(str.length() * 6);

            for(int i = 0; i < str.length(); ++i) {
                char ch = str.charAt(i);
                if(!Character.isDigit(ch) && !Character.isLowerCase(ch) && !Character.isUpperCase(ch)) {
                    if(ch < 256) {
                        sb.append("%");
                        if(ch < 16) {
                            sb.append("0");
                            sb.append(Integer.toString(ch, 16));
                        } else {
                            sb.append(Integer.toString(ch, 16));
                        }
                    } else {
                        sb.append("%u");
                        sb.append(Integer.toString(ch, 16));
                    }
                } else {
                    sb.append(ch);
                }
            }

            return sb.toString();
        }
    }

    public static String unescape(String str) {
        if(str == null) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.ensureCapacity(str.length());
            boolean pos = false;
            int lastPos = 0;

            while(true) {
                while(true) {
                    while(true) {
                        while(lastPos < str.length()) {
                            int pos1 = str.indexOf("%", lastPos);
                            if(pos1 == lastPos) {
                                char ch;
                                if(str.charAt(pos1 + 1) != 85 && str.charAt(pos1 + 1) != 117) {
                                    if(str.charAt(pos1 + 1) != 32 && str.charAt(pos1 + 1) != 59) {
                                        ch = (char)Integer.parseInt(str.substring(pos1 + 1, pos1 + 3), 16);
                                        sb.append(ch);
                                        lastPos = pos1 + 3;
                                    } else {
                                        sb.append(str.substring(pos1, pos1 + 1));
                                        lastPos = pos1 + 1;
                                    }
                                } else {
                                    ch = (char)Integer.parseInt(str.substring(pos1 + 2, pos1 + 6), 16);
                                    sb.append(ch);
                                    lastPos = pos1 + 6;
                                }
                            } else if(pos1 == -1) {
                                sb.append(str.substring(lastPos));
                                lastPos = str.length();
                            } else {
                                sb.append(str.substring(lastPos, pos1));
                                lastPos = pos1;
                            }
                        }

                        return sb.toString();
                    }
                }
            }
        }
    }

    public static String splitString(String str, String type) {
        String sql = "";
        StringBuilder sbf = new StringBuilder();
        if(!isEmpty(str) && !isEmpty(type)) {
            String[] ids = str.split(type);

            for(int i = 0; i < ids.length; ++i) {
                if(ids.length == i + 1) {
                    sbf.append("\'").append(ids[i]).append("\'");
                } else {
                    sbf.append("\'").append(ids[i]).append("\'").append(",");
                }
            }

            sbf.append("");
        } else {
            sbf.append("\'\'");
        }

        return sbf.toString();
    }

    public static String firstCharToLowerCase(String str) {
        Character firstChar = Character.valueOf(str.charAt(0));
        String tail = str.substring(1);
        str = Character.toLowerCase(firstChar.charValue()) + tail;
        return str;
    }

    public static String firstCharToUpperCase(String str) {
        Character firstChar = Character.valueOf(str.charAt(0));
        String tail = str.substring(1);
        str = Character.toUpperCase(firstChar.charValue()) + tail;
        return str;
    }

    public static String filterSpecialCharacter(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}\':;\',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
