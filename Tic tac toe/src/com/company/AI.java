package com.company;

public class AI {

    private boolean diagonal_win(int numMove) {
        if (Main.arr[0][2] + Main.arr[2][0] == 2 * numMove && Main.arr[1][1] == 0) {
            Main.arr[1][1] = numMove;
            return true;
        }
        if (Main.arr[2][0] + Main.arr[1][1] == 2 * numMove && Main.arr[0][2] == 0) {
            Main.arr[0][2] = numMove;
            return true;
        }
        if (Main.arr[0][2] + Main.arr[1][1] == 2 * numMove && Main.arr[2][0] == 0) {
            Main.arr[2][0] = numMove;
            return true;
        }
        return false;
    }

    private boolean diagonal_protection(int numMove) {
        if (Main.arr[0][2] + Main.arr[2][0] == -2 * numMove && Main.arr[1][1] == 0) {
            Main.arr[1][1] = numMove;
            return true;
        }
        if (Main.arr[2][0] + Main.arr[1][1] == -2 * numMove && Main.arr[0][2] == 0) {
            Main.arr[0][2] = numMove;
            return true;
        }
        if (Main.arr[0][2] + Main.arr[1][1] == -2 * numMove && Main.arr[2][0] == 0) {
            Main.arr[2][0] = numMove;
            return true;
        }
        return false;
    }

    private boolean protection_or_win(int numEnemyMove) {
        int sum_hor, sum_ver, sum_diagonal;

        for (int i = 0; i < 3; i++) {                   //----виграш-----
            sum_hor = 0;
            sum_ver = 0;
            sum_diagonal = 0;
            for (int j = 0; j < 3; j++) {
                sum_hor += Main.arr[i][j];
                sum_ver += Main.arr[j][i];
                sum_diagonal += Main.arr[j][j];
                if (numEnemyMove == 1) {
                    if (sum_hor == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[i][x] == 0) {
                                Main.arr[i][x] = -1;
                                return true;
                            }
                        }
                    }
                    if (sum_ver == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][i] == 0) {
                                Main.arr[x][i] = -1;
                                return true;
                            }
                        }
                    }
                    if (sum_diagonal == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][x] == 0) {
                                Main.arr[x][x] = -1;
                                return true;
                            }
                        }
                    }
                    if (diagonal_win(-1)) return true;
                }
                if (numEnemyMove == -1) {
                    if (sum_hor == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[i][x] == 0) {
                                Main.arr[i][x] = 1;
                                return true;
                            }
                        }
                    }
                    if (sum_ver == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][i] == 0) {
                                Main.arr[x][i] = 1;
                                return true;
                            }
                        }
                    }
                    if (sum_diagonal == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][x] == 0) {
                                Main.arr[x][x] = 1;
                                return true;
                            }
                        }
                    }
                    if (diagonal_win(1)) return true;
                }
            }
        }
        for (int i = 0; i < 3; i++) {                   //---------- захист ---------
            sum_hor = 0;
            sum_ver = 0;
            sum_diagonal = 0;
            for (int j = 0; j < 3; j++) {
                sum_hor += Main.arr[i][j];
                sum_ver += Main.arr[j][i];
                sum_diagonal += Main.arr[j][j];
                if (numEnemyMove == 1) {
                    if (sum_hor == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[i][x] == 0) {
                                Main.arr[i][x] = -1;
                                return true;
                            }
                        }
                    }
                    if (sum_ver == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][i] == 0) {
                                Main.arr[x][i] = -1;
                                return true;
                            }
                        }
                    }
                    if (sum_diagonal == 2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][x] == 0) {
                                Main.arr[x][x] = -1;
                                return true;
                            }
                        }
                    }
                    if (diagonal_protection(-1)) return true;
                }
                if (numEnemyMove == -1) {
                    if (sum_hor == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[i][x] == 0) {
                                Main.arr[i][x] = 1;
                                return true;
                            }
                        }
                    }
                    if (sum_ver == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][i] == 0) {
                                Main.arr[x][i] = 1;
                                return true;
                            }
                        }
                    }
                    if (sum_diagonal == -2) {
                        for (int x = 0; x < 3; x++) {
                            if (Main.arr[x][x] == 0) {
                                Main.arr[x][x] = 1;
                                return true;
                            }
                        }
                    }
                    if (diagonal_protection(1)) return true;
                }
            }
        }
        return false;
    }

    private boolean emptyCorner(int numMove) {
        if (Main.arr[0][0] == 0) {
            Main.arr[0][0] = numMove;
            return true;
        }
        if (Main.arr[2][0] == 0) {
            Main.arr[2][0] = numMove;
            return true;
        }
        if (Main.arr[0][2] == 0) {
            Main.arr[0][2] = numMove;
            return true;
        }
        if (Main.arr[2][2] == 0) {
            Main.arr[2][2] = numMove;
            return true;
        }
        return false;
    }

    private boolean anyEmptyCell(int numMove) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Main.arr[i][j] == 0) {
                    Main.arr[i][j] = numMove;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean emptyCenterCell(int numMove) {
        if (Main.arr[1][0] == 0) {
            Main.arr[1][0] = numMove;
            return true;
        }
        if (Main.arr[2][1] == 0) {
            Main.arr[2][1] = numMove;
            return true;
        }
        if (Main.arr[1][2] == 0) {
            Main.arr[1][2] = numMove;
            return true;
        }
        if (Main.arr[0][1] == 0) {
            Main.arr[0][1] = numMove;
            return true;
        }
        return false;
    }

    public void AI_first() {
        if (protection_or_win(-1)) {
        } else {
            if (!emptyCorner(1)) anyEmptyCell(1);
            //else emptyCorner(1);
        }
    }

    public void AI_second(int x, int y) {
        if (protection_or_win(1)) {
        } else {
            if (x == 1 && y == 1) {
                if (!emptyCorner(-1)) anyEmptyCell(-1);
            } else {
                if (Main.arr[1][1] == 0) Main.arr[1][1] = -1;
                else {
                    if (!emptyCenterCell(-1)) anyEmptyCell(-1);
                }
            }
        }
    }

}
