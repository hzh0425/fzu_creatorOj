// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file.proto

package com.moxi.file;

/**
 * <pre>
 *重传某一块
 * </pre>
 *
 * Protobuf type {@code com.moxi.file.ReSend}
 */
public  final class ReSend extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.moxi.file.ReSend)
    ReSendOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReSend.newBuilder() to construct.
  private ReSend(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReSend() {
    currentChunk_ = 0;
    offset_ = 0L;
    length_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReSend(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 16: {

            currentChunk_ = input.readInt32();
            break;
          }
          case 32: {

            offset_ = input.readInt64();
            break;
          }
          case 40: {

            length_ = input.readInt64();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.moxi.file.File.internal_static_com_moxi_file_ReSend_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.moxi.file.File.internal_static_com_moxi_file_ReSend_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.moxi.file.ReSend.class, com.moxi.file.ReSend.Builder.class);
  }

  public static final int CURRENTCHUNK_FIELD_NUMBER = 2;
  private int currentChunk_;
  /**
   * <pre>
   *当前的分块
   * </pre>
   *
   * <code>int32 currentChunk = 2;</code>
   */
  public int getCurrentChunk() {
    return currentChunk_;
  }

  public static final int OFFSET_FIELD_NUMBER = 4;
  private long offset_;
  /**
   * <pre>
   *当前的偏移量
   * </pre>
   *
   * <code>int64 offset = 4;</code>
   */
  public long getOffset() {
    return offset_;
  }

  public static final int LENGTH_FIELD_NUMBER = 5;
  private long length_;
  /**
   * <pre>
   *当前的长度
   * </pre>
   *
   * <code>int64 length = 5;</code>
   */
  public long getLength() {
    return length_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (currentChunk_ != 0) {
      output.writeInt32(2, currentChunk_);
    }
    if (offset_ != 0L) {
      output.writeInt64(4, offset_);
    }
    if (length_ != 0L) {
      output.writeInt64(5, length_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (currentChunk_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, currentChunk_);
    }
    if (offset_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, offset_);
    }
    if (length_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(5, length_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.moxi.file.ReSend)) {
      return super.equals(obj);
    }
    com.moxi.file.ReSend other = (com.moxi.file.ReSend) obj;

    boolean result = true;
    result = result && (getCurrentChunk()
        == other.getCurrentChunk());
    result = result && (getOffset()
        == other.getOffset());
    result = result && (getLength()
        == other.getLength());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CURRENTCHUNK_FIELD_NUMBER;
    hash = (53 * hash) + getCurrentChunk();
    hash = (37 * hash) + OFFSET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getOffset());
    hash = (37 * hash) + LENGTH_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getLength());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.moxi.file.ReSend parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.file.ReSend parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.file.ReSend parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.file.ReSend parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.file.ReSend parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.file.ReSend parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.file.ReSend parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.moxi.file.ReSend parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.moxi.file.ReSend parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.moxi.file.ReSend parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.moxi.file.ReSend parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.moxi.file.ReSend parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.moxi.file.ReSend prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *重传某一块
   * </pre>
   *
   * Protobuf type {@code com.moxi.file.ReSend}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.moxi.file.ReSend)
      com.moxi.file.ReSendOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.moxi.file.File.internal_static_com_moxi_file_ReSend_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.moxi.file.File.internal_static_com_moxi_file_ReSend_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.moxi.file.ReSend.class, com.moxi.file.ReSend.Builder.class);
    }

    // Construct using com.moxi.file.ReSend.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      currentChunk_ = 0;

      offset_ = 0L;

      length_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.moxi.file.File.internal_static_com_moxi_file_ReSend_descriptor;
    }

    public com.moxi.file.ReSend getDefaultInstanceForType() {
      return com.moxi.file.ReSend.getDefaultInstance();
    }

    public com.moxi.file.ReSend build() {
      com.moxi.file.ReSend result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.moxi.file.ReSend buildPartial() {
      com.moxi.file.ReSend result = new com.moxi.file.ReSend(this);
      result.currentChunk_ = currentChunk_;
      result.offset_ = offset_;
      result.length_ = length_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.moxi.file.ReSend) {
        return mergeFrom((com.moxi.file.ReSend)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.moxi.file.ReSend other) {
      if (other == com.moxi.file.ReSend.getDefaultInstance()) return this;
      if (other.getCurrentChunk() != 0) {
        setCurrentChunk(other.getCurrentChunk());
      }
      if (other.getOffset() != 0L) {
        setOffset(other.getOffset());
      }
      if (other.getLength() != 0L) {
        setLength(other.getLength());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.moxi.file.ReSend parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.moxi.file.ReSend) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int currentChunk_ ;
    /**
     * <pre>
     *当前的分块
     * </pre>
     *
     * <code>int32 currentChunk = 2;</code>
     */
    public int getCurrentChunk() {
      return currentChunk_;
    }
    /**
     * <pre>
     *当前的分块
     * </pre>
     *
     * <code>int32 currentChunk = 2;</code>
     */
    public Builder setCurrentChunk(int value) {
      
      currentChunk_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前的分块
     * </pre>
     *
     * <code>int32 currentChunk = 2;</code>
     */
    public Builder clearCurrentChunk() {
      
      currentChunk_ = 0;
      onChanged();
      return this;
    }

    private long offset_ ;
    /**
     * <pre>
     *当前的偏移量
     * </pre>
     *
     * <code>int64 offset = 4;</code>
     */
    public long getOffset() {
      return offset_;
    }
    /**
     * <pre>
     *当前的偏移量
     * </pre>
     *
     * <code>int64 offset = 4;</code>
     */
    public Builder setOffset(long value) {
      
      offset_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前的偏移量
     * </pre>
     *
     * <code>int64 offset = 4;</code>
     */
    public Builder clearOffset() {
      
      offset_ = 0L;
      onChanged();
      return this;
    }

    private long length_ ;
    /**
     * <pre>
     *当前的长度
     * </pre>
     *
     * <code>int64 length = 5;</code>
     */
    public long getLength() {
      return length_;
    }
    /**
     * <pre>
     *当前的长度
     * </pre>
     *
     * <code>int64 length = 5;</code>
     */
    public Builder setLength(long value) {
      
      length_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前的长度
     * </pre>
     *
     * <code>int64 length = 5;</code>
     */
    public Builder clearLength() {
      
      length_ = 0L;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.moxi.file.ReSend)
  }

  // @@protoc_insertion_point(class_scope:com.moxi.file.ReSend)
  private static final com.moxi.file.ReSend DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.moxi.file.ReSend();
  }

  public static com.moxi.file.ReSend getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReSend>
      PARSER = new com.google.protobuf.AbstractParser<ReSend>() {
    public ReSend parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ReSend(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReSend> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReSend> getParserForType() {
    return PARSER;
  }

  public com.moxi.file.ReSend getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
