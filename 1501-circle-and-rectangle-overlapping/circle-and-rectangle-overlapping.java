class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Rectangle ka nearest X point
        int closestX = Math.max(x1, Math.min(xCenter, x2));

        // Rectangle ka nearest Y point
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Circle center se nearest point tak distance
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        // Distance² <= Radius²
        return dx * dx + dy * dy <= radius * radius;
    }
}