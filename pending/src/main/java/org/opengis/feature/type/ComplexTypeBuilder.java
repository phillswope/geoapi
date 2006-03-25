package org.opengis.feature.type;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.opengis.feature.Attribute;
import org.opengis.filter.Filter;

/**
 * A Type builder for creating complex types.
 * <p>
 * Creating useful ComplexType objects using only the TypeFactory is a difficult
 * process. This class is set up to help you construct a Type, the TypeFactory
 * is still used to do the actual creation, this class simply provides help
 * making the right calls.
 * </p>
 * <p>
 * Before use you *must*:
 * <ul>
 * <li>setTypeFactory( TypeFactory )
 * </ul>
 * </p>
 * <p>
 * This class follows the Builder Pattern from the GOF, as such it does
 * <b>maintain state</b>. You can use this class by setting up the state
 * through a series of method calls and then calling the create method().
 * </p>
 * Here is the state that Active Builder will keep for you:
 * <ul>
 * <li>Class to AttributeType bindings, out of the box the following bindings
 * are available:
 * <ul>
 * <li>Number to NumericType
 * <li>Boolean to BooleanType
 * <li>CharSequence to TextAttribute
 * <li>Data tp TemporalAttribute
 * <li>...
 * </ul>
 * Where these AttributType have been construted with the provided factory.
 * </p>
 * <p>
 * In the future it is expected that you can load all the types referenced in a
 * given namespace in one go. Allowing you to teach the builder "ISO Metadata"
 * and "GML2" in a couple of lines.
 * <li>name
 * <li>namespace
 * <li>attributes
 * <li>super
 * <li>isAbstract
 * </ul>
 * <p>
 * <p>
 * After defining your type using the above methods you can call: create()
 * </p>
 * As a safty feature the builder will clear its state after use.
 * <p>
 * 
 * @author Justin Deoliveira, The Open Planning Project, jdeolive@openplans.org
 * @author Jody Garnett, Refractions Research, jgarnett@refractions.net
 * 
 * @param <T>
 *            The attribute type which must be an extension of ComplexType.
 * @param <B>
 *            The class the type is bound, for ComplexType this is a collection
 *            class of Attribute.
 */
public interface ComplexTypeBuilder<C extends Collection<Attribute>, T extends ComplexType<C>> {

	//
	// Dependences Injection
	// (aka what we need to function)
	//

	/**
	 * Returns the underlying type factory.
	 */
	TypeFactory getTypeFactory();

	/**
	 * Sets the underyling type factory.
	 */
	void setTypeFactory(TypeFactory factory);

	//
	// Use
	//

	/**
	 * Initialize the builder based on provided type.
	 */
	void init(T type);

	/**
	 * Create a ComplexType based on the configuration of this builder.
	 * <p>
	 * This method will use the provided TypeFactory to create an ComplexType
	 * based on the builder configuration.
	 */
	T build();

	//
	// Setup
	//
	/**
 	 * AttributeType bound to an indicated class.
 	 * <p>
	 * The following bindings are supported "out of the box":
	 * <ul>
	 * <li>Boolean to BooleanAttribute
	 * <li>Number to NumericAttribute
	 * <li>CharSequence to TextAttribute
	 * <li>Date to TemporalAttribute
	 * <li>
	 * These interfaces may be found in org.opengis.feature.simple.
	 * </ul>
	 * @param binding
	 * @return
	 */
	<B>AttributeType<B> getBinding( Class<B> binding );
	
	/**
	 * Add addutuibak class to AttributeType bindingsto be used when adding
	 * attributes.
	 * <p>
	 * As time goes on we will create namespaces of AttributeTypes that may be
	 * loaded in one go.
	 * </p>
	 * @param <B>
	 * @param binding
	 * @param type
	 * @return
	 */
	<B>AttributeType<B> addBinding( Class<B> binding, AttributeType<B> type );
	


	//
	// State
	//
	// These methods capture state used in helping produce
	// objects.
	//
	/**
	 * Sets the namespace to be used when constructing type and attribute names.
	 */
	void setNamespaceURI(String uri);

	/**
	 * Returns The namespace to be used when constructing type and attribute
	 * names.
	 */
	String getNamespaceURI();

	/**
	 * Sets the name of the type, combined with getNamespaceURI to produce the
	 * TypeName.
	 * <p>
	 * This value must be set prior to calling create()
	 * </p>
	 */
	void setName(String name);

	/**
	 * Returns the name component of the type to be created.
	 */
	String getName();

	/**
	 * The TypeName for the type to be created.
	 * 
	 * @return
	 */
	TypeName getTypeName();

	/**
	 * Provide a TypeName for the type to be created.
	 * <p>
	 * This method is useful when working with TypeNames created by the
	 * application using the library (ie an application specific
	 * implementation).
	 * </p>
	 * 
	 * @param name
	 * @return
	 */
	TypeName setTypeName(TypeName name);

	//
	// Type Metadata
	//

	/**
	 * Sets the abstract property of created types.
	 * 
	 * @see AttributeType#isAbstract()
	 */
	void setAbstract(boolean isAbstract);

	/**
	 * Returns the abstract property of created types.
	 * 
	 * @see AttributeType#isAbstract()
	 */
	boolean isAbstract();

	/**
	 * Sets the super type of created types.
	 * 
	 * @see AttributeType#getSuper()
	 */
	<E extends T> void setSuper(E superType);

	/**
	 * Sets the super type of created types.
	 * 
	 * @see AttributeType#getSuper()
	 */
	<E extends T> E getSuper();

	/**
	 * Sets additional restrictions on created types.
	 * 
	 * @see AttributeType#getRestrictions()
	 */
	void setRestrictions(Set<Filter> restrictions);

	/**
	 * Returns additional restrictions on created types.
	 * 
	 * @see AttributeType#getRestrictions()
	 */
	Set<Filter> getRestrictions();

	//
	// Attributes
	//
	/**
	 * Adds an attribute descriptor to the type being created.
	 * <p>
	 * The attribue descriptor is based on the following:
	 * <ul>
	 * <li>AttributeName based on getNamespaceURI + name
	 * <li>MinOccurs 1
	 * <li>MaxOccurs 1
	 * <li>Nillable true
	 * <li>AttributeType provided by getBinding( binding )
	 * </ul>
	 * </p>
	 * <p>
	 * This method invokes: getAttributes().add( descriptor ), if you require
	 * more control please use this technique directly with your own
	 * AttributeDescriptor.
	 * </p>
	 */
	void add(String name, Class binding);

	/**
	 * Adds an attribute descriptor to the type being created.
	 * <p>
	 * The attribue descriptor is based on the following:
	 * <ul>
	 * <li>AttributeName based on getNamespaceURI + name
	 * <li>MinOccurs 1
	 * <li>MaxOccurs 1
	 * <li>Nillable true
	 * </ul>
	 * </p>
	 * <p>
	 * This method invokes: getAttributes().add( descriptor ), if you require
	 * more control please use this technique directly with your own
	 * AttributeDescriptor.
	 * </p>
	 * 
	 * @param name
	 *            The name of the attribute, combined with namespace for
	 *            AttributeName
	 * @param type
	 *            The type of the attribute, combined with namespacxe for
	 *            AttirbuteName
	 */
	void add(String name, AttributeType type);

	/**
	 * Adds an attribute descriptor to the type.
	 * <p>
	 * The attribue descriptor is based on the following:
	 * <ul>
	 * <li>AttributeName based on getNamespaceURI + name
	 * <li>Nillable true
	 * </ul>
	 * </p>
	 * <p>
	 * This method invokes: getAttributes().add( descriptor ), if you require
	 * more control please use this technique directly with your own
	 * AttributeDescriptor.
	 * </p>
	 * 
	 * @param name
	 *            The name of the attribute.
	 * @param type
	 *            The type of the attribute.
	 * @param minOccurs
	 *            Minimum number of occurences of the attribute.
	 * @param maxOccurs
	 *            Maximum number of occurences of the attribute.
	 */
	void add(String name, AttributeType type, int minOccurs, int maxOccurs);

	/**
	 * This is the list of attribute descriptors maintained by the type builder.
	 * <p>
	 * To add an attribue descriptor: builder.getAttributes().add( descriptor );
	 * </p>
	 * 
	 * @return
	 */
	List<AttributeDescriptor> getAttributes();
}
