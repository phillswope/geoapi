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
package org.opengis.coverage;

// Annotations
import org.opengis.annotation.UML;
import static org.opengis.annotation.Obligation.*;
import static org.opengis.annotation.Specification.*;


/**
 * Describes an element of a set that defines the relationships of a
 * {@linkplain DiscreteCoverage discrete coverage}. Each member of this class consists of two parts:
 * a domain object from the domain of the coverage to which it belongs and a record of feature
 * attribute values from the range of the coverage to which it belongs.
 * <var>geometry</var>-<var>value</var> pairs may be generated in the execution of an
 * {@link Coverage#evaluate(DirectPosition,Collection) evaluate} operation, and need not be
 * persistent. {@code GeometryValuePair} is subclassed to restrict the pairing of a feature
 * attribute value record to a specific subtype of domain object.
 *
 * @author Stephane Fellah
 * @author Martin Desruisseaux
 *
 * @revisit Consider replacing {@code Set<GeometryValuePair>} by {@code Map<DomainObject,Object>}.
 */
@UML(identifier="CV_GeometryValuePair", specification=ISO_19123)
public interface GeometryValuePair {
    /**
     * The domain object that is a member of this <var>geometry</var>-<var>value</var> pair.
     */
    @UML(identifier="geometry", obligation=MANDATORY, specification=ISO_19123)
    DomainObject getDomainObject();  

    /**
     * Holds the record of feature attribute values associated with the domain object.
     */
    @UML(identifier="value", obligation=MANDATORY, specification=ISO_19123)
    Object getValue();
}