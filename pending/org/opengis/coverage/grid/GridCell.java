/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.coverage.grid;

// J2SE direct dependencies
import java.util.Set;

// Annotations
import org.opengis.annotation.UML;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * A grid cell delineated by the grid lines of a {@linkplain Grid grid}. Its corners
 * are associated with the {@linkplain GridPoint grid points} at the intersections of
 * the grid lines that bound it
 * 
 * @author Martin Schouwenburg
 * @author Wim Koolhoven
 * @author Martin Desruisseaux
 */
@UML(identifier="CV_GridCell", specification=ISO_19123)
public interface GridCell {
	/**
	 * Returns the collection of {@linkplain GridPoint grid points} at the corners of the grid cell. 
     * The size of this collection has no upper bound, to allow for grids of any dimension.
     * In a quadrilateral grid, the multiplicity of corner equals 2&times;<var>d</var>, where
     * <var>d</var> is the value of {@link Grid#getDimension}.
	 */
    @UML(identifier="Location", obligation=MANDATORY, specification=ISO_19123)
	Set<GridPoint> getLocation();

    /**
     * Returns the {@linkplain Grid grid} of which this cell is a component.
     */
    @UML(identifier="EvaluationStructure", obligation=MANDATORY, specification=ISO_19123)
    Grid getEvaluationStructure();
}