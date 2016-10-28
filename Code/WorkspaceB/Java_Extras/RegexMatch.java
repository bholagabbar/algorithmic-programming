public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;
    return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
}

private boolean isMatch(char[] s, int i, char[] p, int j) {
    if (j == p.length) return i == s.length;
    if (j == p.length - 1 || p[j + 1] != '*') {
        if (i < s.length && (p[j] == '.' || s[i] == p[j])) {
            return isMatch(s, i + 1, p, j + 1);
        } else {
            return false;
        }
    }
    while (i < s.length && (p[j] == '.' || s[i] == p[j])) {
        if (isMatch(s, i, p, j + 2)) return true;
        i++;
    }
    return isMatch(s, i, p, j + 2);
}