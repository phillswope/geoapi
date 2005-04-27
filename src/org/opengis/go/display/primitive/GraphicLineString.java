/**************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.go.display.primitive;

// OpenGIS direct dependencies
import org.opengis.go.display.style.LineSymbolizer;
import org.opengis.go.spatial.PathType;
import org.opengis.spatialschema.geometry.DirectPosition;


/**
 * Defines a common abstraction for implementations of 1-dimensional lines made
 * up of one or more line segments.
 *
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version $Revision$, $Date$
 * @since GO 1.1
 */
public interface GraphicLineString extends Graphic {
    
    /**
     * Returns the positions that make up the line segments.
     * Value is acquired from the underlying LineString geometry for this Graphic.
     *
     * @return the array positions.
     */
    public DirectPosition[] getPoints();

    /**
     * Sets the positions that make up the line segments.
     * Value is set on the underlying LineString geometry for this Graphic.
     *
     * @param coords the array positions.
     */
    public void setPoints(DirectPosition[] coords);

    /**
     * Appends the given position to the graphic linestring's array of
     * positions.
     * Value is set on the underlying LineString geometry for this Graphic.
     *
     * @param coord the postion to add.
     */
    public void addPoint(DirectPosition coord);

    /**
     * Removes the postion at the specified index from the array of 
     * positions.
     * Value is deleted on the underlying LineString geometry for this Graphic.
     *
     * @param index the index of the position to remove.
     */
    public void deletePoint(int index);

    /**
     * Returns the position at the specified index in the array of
     * positions.
     * Value is acquired from the underlying LineString geometry for this Graphic.
     *
     * @param index the index of the position to return.
     * @return the position at the given index.
     */
    public DirectPosition getPoint(int index);

    /**
     * Inserts the given position at the specified index in the array
     * of positions.
     * Value is inserted on the underlying LineString geometry for this Graphic.
     *
     * @param index the index to insert the new position at.
     * @param coord the position to insert.
     */
    public void insertPoint(int index, DirectPosition coord);

    /**
     * Replaces the position at the specified index in the array of positions
     * with the new, specified position.
     * Value is set on the underlying LineString geometry for this Graphic.
     *
     * @param index the index of the position to replace.
     * @param coord the position to store at the specified index.
     */
    public void setPoint(int index, DirectPosition coord);

    /**
     * Returns the boolean flag indicating whether the graphic linestring is
     * closed (its first and last points are the same) or open.
     *
     * @return whether or not the graphic linestring is closed.
     */
    public boolean isClosed();
    
    /**
     * Returns the <code>GraphicStyle</code> for this <code>GraphicLineString</code>,
     * which is required to be a <code>LineSymbolizer</code>.
     * @return the GraphicLineString's <code>GraphicStyle</code>.
     */
    public LineSymbolizer getLineSymbolizer();

    //**  EDITABLE/ANIMATION  **

    /**
     * Indicates whether clicking on an edge of this graphic linestring should insert
     * a new vertex at that location when the object is in edit mode.
     */
    public boolean isAllowingNewVertices();

    /**
     * Sets the boolean that indicates whether clicking on an edge of this
     * graphic linestring should insert a new vertex at that location.
     */
    public void setAllowingNewVertices(boolean newValue);

    //**  PROJECTED  **

    /**
     * Sets the method that is used in computing the "in-between" pixels
     * between vertices when this object is rendered on the screen.
     *
     * @param pathType The new path type. This must be one of the static constants in
     *   the PathType class or one of its subclasses.
     */
    public void setPathType(PathType pathType);

    /**
     * Retrieves the methods that is used in computing the "in-between"
     * pixels between vertices when this object is rendered on the screen.
     */
    public PathType getPathType();

}

