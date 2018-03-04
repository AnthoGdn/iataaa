package com.iataaa.checkersRules.rules;

import com.iataaa.checkersRules.model.Case;
import com.iataaa.checkersRules.model.Couple;
import com.iataaa.checkersRules.model.EnumPlayer;
import com.iataaa.checkersRules.model.Game;

import java.util.ArrayList;
import java.util.List;

public class CheckersRules {

    private static final int FIRST_POSITION_OF_LAST_LINE = Game.CASE_NB_OF_LINE
        * (Game.LINE_NB - 1);
    private static final int LAST_POSITION_OF_FIRST_LINE = Game.CASE_NB_OF_LINE - 1;

    private static List<Case[]> availableMoves = new ArrayList<>();
    private static int moveSize = 1;

    public static List<Case[]> getAvailableMoves(Case[] cases, EnumPlayer p) {
        List<Integer> whiteCases;
        if (p == EnumPlayer.PLAYER_2) {
            cases = reverseCases(cases);
        }
        whiteCases = getWhiteCases(cases);

        final Case[] finalCases = cases;
        whiteCases.forEach(whiteCase -> fillAvailableMovesForOneCase(finalCases, whiteCase));

        transformPieceToQueen();

        List<Case[]> availableMovesList;
        if (p == EnumPlayer.PLAYER_2) {
            availableMovesList = new ArrayList<>();
            availableMoves.forEach((c) -> availableMovesList.add(reverseCases(c)));
        } else {
            availableMovesList = availableMoves;
        }
        List<Case[]> result = new ArrayList<>(availableMovesList);
        availableMoves.clear();
        moveSize = 1;

        return result;
    }


// PRIVATE
    
    // Return -1 if result don't exist.
    private static int getTopLeftCornerPosition(int position) {
        int res = -1;
        if ( !(position % 10 == 0 || position >= FIRST_POSITION_OF_LAST_LINE) ) {
            res = position + (position / 5) % 2 + (Game.PIECE_SIZE / 10) - 1;
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static int getTopRightCornerPosition(int position) {
        int res = -1;
        if ( !( (position + 1) % 10 == 0 || position >= FIRST_POSITION_OF_LAST_LINE) ) {
            res = position + (position / 5) % 2 + (Game.PIECE_SIZE / 10);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static int getBottomLeftCornerPosition(int position) {
        int res = -1;
        if ( !(position % 10 == 0 || position <= LAST_POSITION_OF_FIRST_LINE) ) {
            // Arrière gauche : pos - (SIZE/10)-1 - (pos/5)%2
            res = position - (Game.PIECE_SIZE / 10)  - (((position / 5) + 1) % 2);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static int getBottomRightCornerPosition(int position) {
        int res = -1;
        if ( !( (position + 1) % 10 == 0 || position <= LAST_POSITION_OF_FIRST_LINE) ) {
            res = position - Game.PIECE_SIZE / 10  - ((position / 5 + 1) % 2) + 1;
        }
        return res;
    }

    // Return -1 if result don't exist.
    public static int getTopLeftCornerPosition(int position, int distance) {
        int tmpPosition = position;
        do {
            tmpPosition = getTopLeftCornerPosition(tmpPosition);
            --distance;
        } while (tmpPosition != -1 && distance > 0);
        return tmpPosition;
    }

    // Return -1 if result don't exist.
    public static int getTopRightCornerPosition(int position, int distance) {
        int tmpPosition = position;
        do {
            tmpPosition = getTopRightCornerPosition(tmpPosition);
            --distance;
        } while (tmpPosition != -1 && distance > 0);
        return tmpPosition;
    }

    // Return -1 if result don't exist.
    public static int getBottomLeftCornerPosition(int position, int distance) {
        int tmpPosition = position;
        do {
            tmpPosition = getBottomLeftCornerPosition(tmpPosition);
            --distance;
        } while (tmpPosition != -1 && distance > 0);
        return tmpPosition;
    }

    // Return -1 if result don't exist.
    public static int getBottomRightCornerPosition(int position, int distance) {
        int tmpPosition = position;
        do {
            tmpPosition = getBottomRightCornerPosition(tmpPosition);
            --distance;
        } while (tmpPosition != -1 && distance > 0);
        return tmpPosition;
    }


    // Return -1 if result don't exist.
    private static List<Integer> getAllTopLeftCornerPositions(int position) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getTopLeftCornerPosition(position);
                tmpPosition != -1;
                tmpPosition = getTopLeftCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    static List<Integer> getAllTopRightCornerPositions(int position) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getTopRightCornerPosition(position);
                tmpPosition != -1;
                tmpPosition = getTopRightCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    public static List<Integer> getAllBottomLeftCornerPositions(int position) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getBottomLeftCornerPosition(position);
                tmpPosition != -1;
                tmpPosition = getBottomLeftCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    public static List<Integer> getAllBottomRightCornerPositions(int position) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getBottomRightCornerPosition(position);
                tmpPosition != -1;
                tmpPosition = getBottomRightCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static List<Integer> getAllTopLeftCornerPositions(int src, int tgt) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getTopLeftCornerPosition(src);
                tmpPosition != -1 && tmpPosition != tgt;
                tmpPosition = getTopLeftCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static List<Integer> getAllTopRightCornerPositions(int src, int tgt) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getTopRightCornerPosition(src);
                tmpPosition != -1 && tmpPosition != tgt;
                tmpPosition = getTopRightCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static List<Integer> getAllBottomLeftCornerPositions(int src, int tgt) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getBottomLeftCornerPosition(src);
                tmpPosition != -1 && tmpPosition != tgt;
                tmpPosition = getBottomLeftCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    // Return -1 if result don't exist.
    private static List<Integer> getAllBottomRightCornerPositions(int src, int tgt) {
        List<Integer> res = new ArrayList<>();
        for (
                int tmpPosition = getBottomRightCornerPosition(src);
                tmpPosition != -1 && tmpPosition != tgt;
                tmpPosition = getBottomRightCornerPosition(tmpPosition)
        ) {
            res.add(tmpPosition);
        }
        return res;
    }

    private static void addMoveInAvailableMoves(int position, Case[] pieces, int srcPosition) {
        if (position != -1) {
            Case boardCase = pieces[position];
            if (boardCase == Case.EMPTY) {
                Case[] move = getMoveWhiteCase(pieces, srcPosition, position);
                availableMoves.add(move);
            }
        }
    }

    private static void addMovesInAvailableMovesForQueen(List<Integer> positions, Case[] pieces, int srcPosition) {
        int k, i;
        Case[] newCases;
        int sizePositions = positions.size();
        if (!positions.isEmpty()) {
            i = 0;
            k = positions.get(i);
            while (i < sizePositions && pieces[k] == Case.EMPTY) {
                // We add all position until we meet a piece.
                newCases = getMoveWhiteCase(pieces, srcPosition, k);
                availableMoves.add(newCases);
                k = positions.get(i);
                ++i;
                if (i < sizePositions) {
                    k = positions.get(i);
                }
            }
        }
    }

    // Fill availableMoves of all possible moves
    private static void fillAvailableMovesForOneCase(Case[] pieces, int srcPosition) {
        assert pieces[srcPosition] != Case.BLACK_PIECE;
        assert pieces[srcPosition] != Case.BLACK_QUEEN;
        assert pieces[srcPosition] != Case.EMPTY;

        boolean isPossibleToJump = sequenceJump(pieces, srcPosition, 1, new ArrayList<>());
        if (!isPossibleToJump && moveSize == 1) { // If we can't jump a piece.
            // If moveSize is not equal to 1 then it's useless
            // to continue because there are more long move in avalaibleMove.
            if (pieces[srcPosition] == Case.WHITE_PIECE) {
                // If piece is not queen and it can't jump piece.

            //------------------------------------------------------------------
                // Left side piece.
                int topLeftCornerPosition = getTopLeftCornerPosition(srcPosition);
                if (topLeftCornerPosition != -1) {
                    addMoveInAvailableMoves(topLeftCornerPosition, pieces, srcPosition);
                }
                //------------------------------------------------------------------
                // Right side piece.
                int topRightCornerPosition = getTopRightCornerPosition(srcPosition);
                if (topRightCornerPosition != -1) {
                    addMoveInAvailableMoves(topRightCornerPosition, pieces, srcPosition);
                }
            } else {
                // Piece is a queen and it can't jump piece.
                addMovesInAvailableMovesForQueen(getAllTopLeftCornerPositions(srcPosition), pieces, srcPosition);
                addMovesInAvailableMovesForQueen(getAllTopRightCornerPositions(srcPosition), pieces, srcPosition);
                addMovesInAvailableMovesForQueen(getAllBottomLeftCornerPositions(srcPosition), pieces, srcPosition);
                addMovesInAvailableMovesForQueen(getAllBottomRightCornerPositions(srcPosition), pieces, srcPosition);
            }
        }
    }
    private static boolean isNotInInterval(int src, int tgt, Direction direction, List<Integer> prohibited) {
        List<Integer> positions;
        switch (direction) {
            case TOP_LEFT :
                positions = getAllTopLeftCornerPositions(src, tgt);
                break;
            case TOP_RIGHT :
                positions = getAllTopRightCornerPositions(src, tgt);
                break;
            case BOTTOM_LEFT :
                positions = getAllBottomLeftCornerPositions(src, tgt);
                break;
            default :
                positions = getAllBottomRightCornerPositions(src, tgt);
                break;
        }
        return prohibited.stream().noneMatch(positions::contains);
    }

    // Return false if piece can't jump piece. Else true and save more longer moves in availableMoves.
    private static boolean sequenceJump(
            Case[] pieces,
            int srcPosition,
            final int size,
            List<Integer> jumpedCases
    ) {
        assert pieces[srcPosition] != Case.BLACK_PIECE;
        assert pieces[srcPosition] != Case.BLACK_QUEEN;
        assert pieces[srcPosition] != Case.EMPTY;

        boolean isPossibleToJump = false;

        if (pieces[srcPosition] == Case.WHITE_PIECE) {
            int tgtPosition;
            int jumpedPosition;
            boolean addJumpedMoveToSequence;

        // Top left
            jumpedPosition = getTopLeftCornerPosition(srcPosition);
            tgtPosition = getTopLeftCornerPosition(srcPosition, 2);
            addJumpedMoveToSequence = addJumpedMoveToSequence(pieces,
                srcPosition, jumpedPosition, tgtPosition, size);
            isPossibleToJump = addJumpedMoveToSequence;

        // Top right
            jumpedPosition = getTopRightCornerPosition(srcPosition);
            tgtPosition = getTopRightCornerPosition(srcPosition, 2);
            addJumpedMoveToSequence = addJumpedMoveToSequence(pieces,
                srcPosition, jumpedPosition, tgtPosition, size);
            isPossibleToJump = isPossibleToJump || addJumpedMoveToSequence;

        // Bottom left
            jumpedPosition = getBottomLeftCornerPosition(srcPosition);
            tgtPosition = getBottomLeftCornerPosition(srcPosition, 2);
            addJumpedMoveToSequence = addJumpedMoveToSequence(pieces,
                srcPosition, jumpedPosition, tgtPosition, size);
            isPossibleToJump = isPossibleToJump || addJumpedMoveToSequence;

        // Bottom right
            jumpedPosition = getBottomRightCornerPosition(srcPosition);
            tgtPosition = getBottomRightCornerPosition(srcPosition, 2);
            addJumpedMoveToSequence = addJumpedMoveToSequence(pieces,
                srcPosition, jumpedPosition, tgtPosition, size);
            isPossibleToJump = isPossibleToJump || addJumpedMoveToSequence;

        } else { // If piece is queen
            List<Integer> positions;
            Case[] newCases;
            int jumpedPos;
            Couple<List<Integer>, Integer> couple;

            // Top left
            positions = getAllTopLeftCornerPositions(srcPosition);
            couple = getPositionsToJump(pieces, positions);
            positions = couple.getFirst();
            jumpedPos = couple.getSecond();
            if (jumpedPos != -1) {
                for (int tgtPos : positions) {
                    if (isNotInInterval(srcPosition, tgtPos, Direction.TOP_LEFT, jumpedCases)) {
                        isPossibleToJump = true;
                        newCases = getJumpBlackCase(pieces, srcPosition, jumpedPos, tgtPos);
                        jumpedCases.add(jumpedPos);
                        sequenceJump(newCases, tgtPos, size + 1, jumpedCases);
                        jumpedCases.remove(jumpedCases.indexOf(jumpedPos));
                    }
                }
            }

            // Top right
            positions = getAllTopRightCornerPositions(srcPosition);
            couple = getPositionsToJump(pieces, positions);
            positions = couple.getFirst();
            jumpedPos = couple.getSecond();
            if (jumpedPos != -1) {
                for (int tgtPos : positions) {
                    if (isNotInInterval(srcPosition, tgtPos, Direction.TOP_RIGHT, jumpedCases)) {
                        isPossibleToJump = true;
                        newCases = getJumpBlackCase(pieces, srcPosition, jumpedPos, tgtPos);
                        jumpedCases.add(jumpedPos);
                        sequenceJump(newCases, tgtPos, size + 1, jumpedCases);
                        jumpedCases.remove(jumpedCases.indexOf(jumpedPos));
                    }
                }
            }


            // Bottom left
            positions = getAllBottomLeftCornerPositions(srcPosition);
            couple = getPositionsToJump(pieces, positions);
            positions = couple.getFirst();
            jumpedPos = couple.getSecond();
            if (jumpedPos != -1) {
                for (int tgtPos : positions) {
                    if (isNotInInterval(srcPosition, tgtPos, Direction.BOTTOM_LEFT, jumpedCases)) {
                        isPossibleToJump = true;
                        newCases = getJumpBlackCase(pieces, srcPosition, jumpedPos, tgtPos);
                        jumpedCases.add(jumpedPos);
                        sequenceJump(newCases, tgtPos, size + 1, jumpedCases);
                        jumpedCases.remove(jumpedCases.indexOf(jumpedPos));
                    }
                }
            }


            // Bottom right
            positions = getAllBottomRightCornerPositions(srcPosition);
            couple = getPositionsToJump(pieces, positions);
            positions = couple.getFirst();
            jumpedPos = couple.getSecond();
            if (jumpedPos != -1) {
                for (int tgtPos : positions) {
                    if (isNotInInterval(srcPosition, tgtPos, Direction.BOTTOM_RIGHT, jumpedCases)) {
                        isPossibleToJump = true;
                        newCases = getJumpBlackCase(pieces, srcPosition, jumpedPos, tgtPos);
                        jumpedCases.add(jumpedPos);
                        sequenceJump(newCases, tgtPos, size + 1, jumpedCases);
                        jumpedCases.remove(jumpedCases.indexOf(jumpedPos));
                    }
                }
            }
        }

        if (size != 1 && !isPossibleToJump) {
            // If size == 1 so method runs for first time (in recursion) and we return directly isPossibleMove.
            // Else it's not first run. We verify availableMoves list. We add more longer move and clear others.

            if (size == moveSize) {
                availableMoves.add(pieces);
            } else if (size > moveSize) {
                moveSize = size;
                availableMoves.clear();
                availableMoves.add(pieces);
            }
        }

        return isPossibleToJump;
    }

    // Positions is diagonal positions list.
    // This method return positions list where queen can move after jump piece
    // and return jumped piece position.
    // If getPositionsToJump(..).getSecond == -1 then queen can't jump piece.
    private static Couple<List<Integer>, Integer> getPositionsToJump(Case[] pieces, List<Integer> positions) {
        List<Integer> positionsToJump = new ArrayList<>();
        int jumpedPosition = -1;
        if (!positions.isEmpty()) {
            int i = 0;
            int k = positions.get(i);
            while (pieces[k] == Case.EMPTY && i < positions.size()) {
                ++i;
                if (i < positions.size()) {
                    k = positions.get(i);
                }
            }
            if (i < positions.size() &&
                (pieces[k] == Case.BLACK_PIECE
                || pieces[k] == Case.BLACK_QUEEN)) {

                jumpedPosition = k;
                ++i;
                if (i < positions.size()) {
                    k = positions.get(i);
                    if (pieces[k] != Case.EMPTY) {
                        jumpedPosition = -1;
                    }
                    while (pieces[k] == Case.EMPTY && i < positions.size()) {
                        positionsToJump.add(k);
                        ++i;
                        if (i < positions.size()) {
                            k = positions.get(i);
                        }
                    }
                }
            }
        }
        return new Couple<>(positionsToJump, jumpedPosition);
    }


    private static boolean addJumpedMoveToSequence(
            Case[] pieces,
            int srcPosition,
            int jumpedPosition,
            int tgtPosition,
            int size
    ) {
        boolean isPossibleToJump = false;
        if (jumpedPosition != -1 && tgtPosition != -1) {
            if (pieces[tgtPosition] == Case.EMPTY
                && (pieces[jumpedPosition] == Case.BLACK_PIECE
                    || pieces[jumpedPosition] == Case.BLACK_QUEEN)
            ) {
                // If piece can jump adverse piece in top left corner
                isPossibleToJump = true;
                Case[] newCases = getJumpBlackCase(pieces, srcPosition, jumpedPosition, tgtPosition);
                sequenceJump(newCases, tgtPosition, size + 1, null);
            }
        }
        return isPossibleToJump;
    }

    // Return case list without black piece in jumpedPosition.
    // And white piece in srcPosition move to tgtPosition.
    private static Case[] getJumpBlackCase(
            Case[] pieces, int srcPosition, int jumpedPosition, int tgtPosition
    ) {

        assert (pieces[srcPosition] == Case.WHITE_QUEEN)
            || pieces[srcPosition] == Case.WHITE_PIECE;
        assert pieces[tgtPosition] == Case.EMPTY;
        assert pieces[jumpedPosition] == Case.BLACK_PIECE
            || pieces[jumpedPosition] == Case.BLACK_QUEEN;
        Case[] res = pieces.clone();
        Case srcPi = res[srcPosition];
        res[srcPosition] = Case.EMPTY;
        res[jumpedPosition] = Case.EMPTY;
        res[tgtPosition] = srcPi;
        return res;
    }

    // Return case list with white piece in srcPosition move to tgtPosition.
    private static Case[] getMoveWhiteCase(Case[] pieces, int srcPosition, int tgtPosition) {
        assert pieces[srcPosition] != Case.BLACK_PIECE;
        assert pieces[srcPosition] != Case.BLACK_QUEEN;
        assert pieces[srcPosition] != Case.EMPTY;
        assert pieces[tgtPosition] == Case.EMPTY;

        Case[] res = pieces.clone();
        Case p = res[srcPosition];
        res[srcPosition] = Case.EMPTY;
        res[tgtPosition] = p;
        return res;
    }

    private static List<Integer> getWhiteCases(Case[] pieces) {
        List<Integer> positions = new ArrayList<>(15);
        for (int i = 0; i < pieces.length; ++i) {
            if (pieces[i] == Case.WHITE_PIECE || pieces[i] == Case.WHITE_QUEEN) {
                positions.add(i);
            }
        }
        return positions;
    }

    private static int reverseCaseIndice(int indice) {
        assert indice >= 0 && indice < Game.PIECE_SIZE : "indice = " + indice;
        return 49 - indice;
    }

    public static Case[] reverseCases(Case[] pieces) {
        Case[] reverseCases = new Case[Game.PIECE_SIZE];
        for (int i = 0; i < Game.PIECE_SIZE; ++i) {
            reverseCases[reverseCaseIndice(i)] = oppositeColor(pieces[i]);
        }

        return reverseCases;
    }

    private static Case oppositeColor(Case piece) {
        Case opposite;
        switch (piece) {
            case WHITE_PIECE :
                opposite = Case.BLACK_PIECE;
                break;
            case BLACK_PIECE :
                opposite = Case.WHITE_PIECE;
                break;
            case WHITE_QUEEN :
                opposite = Case.BLACK_QUEEN;
                break;
            case BLACK_QUEEN :
                opposite = Case.WHITE_QUEEN;
                break;
            default :
                opposite = Case.EMPTY;
                break;
        }

        return opposite;
    }
    
    private static void transformPieceToQueen() {
        availableMoves.forEach((pcs) -> {
            for (int i = 49; i >= 45; --i) {
                if (pcs[i] == Case.WHITE_PIECE) {
                    pcs[i] = Case.WHITE_QUEEN;
                }
            }
        });
    }

// ENUM

    private enum Direction {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }
}
