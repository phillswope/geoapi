/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.spatialschema.geometry.geometry;

// J2SE dependencies
import java.util.List;

// Annotations
///import org.opengis.annotation.UML;
///import static org.opengis.annotation.Obligation.*;


/**
 * A {@linkplain GriddedSurface gridded surface} that uses cubic polynomial splines as the
 * horizontal and vertical curves. The initial tangents for the splines are often replaced
 * by an extra pair of rows (and columns) of control points.
 * <br><br>
 * The horizontal and vertical curves require initial and final tangent vectors for a complete
 * definition. These values are supplied by the four methods defined in this interface.
 *
 * @author ISO/DIS 19107
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version 2.0
 */
///@UML (identifier="GM_BicubicGrid")
public interface BicubicGrid extends GriddedSurface {
    /**
     * Returns the initial tangent vectors.
     */
/// @UML (identifier="horiVectorAtStart", obligation=MANDATORY)
    List/*<double[]>*/ getHorizontalVectorAtStart();

    /**
     * Returns the initial tangent vectors.
     */
/// @UML (identifier="horiVectorAtEnd", obligation=MANDATORY)
    List/*<double[]>*/ getHorizontalVectorAtEnd();

    /**
     * Returns the initial tangent vectors.
     */
/// @UML (identifier="vertVectorAtStart", obligation=MANDATORY)
    List/*<double[]>*/ getVerticalVectorAtStart();

    /**
     * Returns the initial tangent vectors.
     */
/// @UML (identifier="vertVectorAtEnd", obligation=MANDATORY)
    List/*<double[]>*/ getVerticalVectorAtEnd();
}