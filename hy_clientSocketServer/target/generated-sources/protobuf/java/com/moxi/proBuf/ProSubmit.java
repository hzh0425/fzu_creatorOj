// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProEvent.proto

package com.moxi.proBuf;

/**
 * Protobuf type {@code com.moxi.proBuf.ProSubmit}
 */
public  final class ProSubmit extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.moxi.proBuf.ProSubmit)
    ProSubmitOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProSubmit.newBuilder() to construct.
  private ProSubmit(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProSubmit() {
    eventType_ = "";
    userId_ = "";
    examId_ = "";
    bankId_ = "";
    submitCode_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ProSubmit(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            userId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            examId_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            bankId_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            submitCode_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            eventType_ = s;
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
    return com.moxi.proBuf.ProEventOuterClass.internal_static_com_moxi_proBuf_ProSubmit_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.moxi.proBuf.ProEventOuterClass.internal_static_com_moxi_proBuf_ProSubmit_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.moxi.proBuf.ProSubmit.class, com.moxi.proBuf.ProSubmit.Builder.class);
  }

  public static final int EVENTTYPE_FIELD_NUMBER = 6;
  private volatile java.lang.Object eventType_;
  /**
   * <code>string eventType = 6;</code>
   */
  public java.lang.String getEventType() {
    java.lang.Object ref = eventType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      eventType_ = s;
      return s;
    }
  }
  /**
   * <code>string eventType = 6;</code>
   */
  public com.google.protobuf.ByteString
      getEventTypeBytes() {
    java.lang.Object ref = eventType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      eventType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private volatile java.lang.Object userId_;
  /**
   * <pre>
   **
   * 用户id
   * </pre>
   *
   * <code>string userId = 1;</code>
   */
  public java.lang.String getUserId() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   **
   * 用户id
   * </pre>
   *
   * <code>string userId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUserIdBytes() {
    java.lang.Object ref = userId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EXAMID_FIELD_NUMBER = 2;
  private volatile java.lang.Object examId_;
  /**
   * <pre>
   **
   * 考试的id
   * </pre>
   *
   * <code>string examId = 2;</code>
   */
  public java.lang.String getExamId() {
    java.lang.Object ref = examId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      examId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   **
   * 考试的id
   * </pre>
   *
   * <code>string examId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getExamIdBytes() {
    java.lang.Object ref = examId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      examId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int BANKID_FIELD_NUMBER = 3;
  private volatile java.lang.Object bankId_;
  /**
   * <pre>
   **
   * 考试的题库id
   * </pre>
   *
   * <code>string bankId = 3;</code>
   */
  public java.lang.String getBankId() {
    java.lang.Object ref = bankId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      bankId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   **
   * 考试的题库id
   * </pre>
   *
   * <code>string bankId = 3;</code>
   */
  public com.google.protobuf.ByteString
      getBankIdBytes() {
    java.lang.Object ref = bankId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      bankId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SUBMITCODE_FIELD_NUMBER = 5;
  private volatile java.lang.Object submitCode_;
  /**
   * <pre>
   **
   * 提交的代码
   * </pre>
   *
   * <code>string submitCode = 5;</code>
   */
  public java.lang.String getSubmitCode() {
    java.lang.Object ref = submitCode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      submitCode_ = s;
      return s;
    }
  }
  /**
   * <pre>
   **
   * 提交的代码
   * </pre>
   *
   * <code>string submitCode = 5;</code>
   */
  public com.google.protobuf.ByteString
      getSubmitCodeBytes() {
    java.lang.Object ref = submitCode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      submitCode_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getUserIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userId_);
    }
    if (!getExamIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, examId_);
    }
    if (!getBankIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, bankId_);
    }
    if (!getSubmitCodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, submitCode_);
    }
    if (!getEventTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, eventType_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userId_);
    }
    if (!getExamIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, examId_);
    }
    if (!getBankIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, bankId_);
    }
    if (!getSubmitCodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, submitCode_);
    }
    if (!getEventTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, eventType_);
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
    if (!(obj instanceof com.moxi.proBuf.ProSubmit)) {
      return super.equals(obj);
    }
    com.moxi.proBuf.ProSubmit other = (com.moxi.proBuf.ProSubmit) obj;

    boolean result = true;
    result = result && getEventType()
        .equals(other.getEventType());
    result = result && getUserId()
        .equals(other.getUserId());
    result = result && getExamId()
        .equals(other.getExamId());
    result = result && getBankId()
        .equals(other.getBankId());
    result = result && getSubmitCode()
        .equals(other.getSubmitCode());
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
    hash = (37 * hash) + EVENTTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getEventType().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId().hashCode();
    hash = (37 * hash) + EXAMID_FIELD_NUMBER;
    hash = (53 * hash) + getExamId().hashCode();
    hash = (37 * hash) + BANKID_FIELD_NUMBER;
    hash = (53 * hash) + getBankId().hashCode();
    hash = (37 * hash) + SUBMITCODE_FIELD_NUMBER;
    hash = (53 * hash) + getSubmitCode().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.moxi.proBuf.ProSubmit parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.moxi.proBuf.ProSubmit parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.moxi.proBuf.ProSubmit parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.moxi.proBuf.ProSubmit parseFrom(
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
  public static Builder newBuilder(com.moxi.proBuf.ProSubmit prototype) {
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
   * Protobuf type {@code com.moxi.proBuf.ProSubmit}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.moxi.proBuf.ProSubmit)
      com.moxi.proBuf.ProSubmitOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.moxi.proBuf.ProEventOuterClass.internal_static_com_moxi_proBuf_ProSubmit_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.moxi.proBuf.ProEventOuterClass.internal_static_com_moxi_proBuf_ProSubmit_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.moxi.proBuf.ProSubmit.class, com.moxi.proBuf.ProSubmit.Builder.class);
    }

    // Construct using com.moxi.proBuf.ProSubmit.newBuilder()
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
      eventType_ = "";

      userId_ = "";

      examId_ = "";

      bankId_ = "";

      submitCode_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.moxi.proBuf.ProEventOuterClass.internal_static_com_moxi_proBuf_ProSubmit_descriptor;
    }

    public com.moxi.proBuf.ProSubmit getDefaultInstanceForType() {
      return com.moxi.proBuf.ProSubmit.getDefaultInstance();
    }

    public com.moxi.proBuf.ProSubmit build() {
      com.moxi.proBuf.ProSubmit result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.moxi.proBuf.ProSubmit buildPartial() {
      com.moxi.proBuf.ProSubmit result = new com.moxi.proBuf.ProSubmit(this);
      result.eventType_ = eventType_;
      result.userId_ = userId_;
      result.examId_ = examId_;
      result.bankId_ = bankId_;
      result.submitCode_ = submitCode_;
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
      if (other instanceof com.moxi.proBuf.ProSubmit) {
        return mergeFrom((com.moxi.proBuf.ProSubmit)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.moxi.proBuf.ProSubmit other) {
      if (other == com.moxi.proBuf.ProSubmit.getDefaultInstance()) return this;
      if (!other.getEventType().isEmpty()) {
        eventType_ = other.eventType_;
        onChanged();
      }
      if (!other.getUserId().isEmpty()) {
        userId_ = other.userId_;
        onChanged();
      }
      if (!other.getExamId().isEmpty()) {
        examId_ = other.examId_;
        onChanged();
      }
      if (!other.getBankId().isEmpty()) {
        bankId_ = other.bankId_;
        onChanged();
      }
      if (!other.getSubmitCode().isEmpty()) {
        submitCode_ = other.submitCode_;
        onChanged();
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
      com.moxi.proBuf.ProSubmit parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.moxi.proBuf.ProSubmit) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object eventType_ = "";
    /**
     * <code>string eventType = 6;</code>
     */
    public java.lang.String getEventType() {
      java.lang.Object ref = eventType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        eventType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string eventType = 6;</code>
     */
    public com.google.protobuf.ByteString
        getEventTypeBytes() {
      java.lang.Object ref = eventType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        eventType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string eventType = 6;</code>
     */
    public Builder setEventType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      eventType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string eventType = 6;</code>
     */
    public Builder clearEventType() {
      
      eventType_ = getDefaultInstance().getEventType();
      onChanged();
      return this;
    }
    /**
     * <code>string eventType = 6;</code>
     */
    public Builder setEventTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      eventType_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object userId_ = "";
    /**
     * <pre>
     **
     * 用户id
     * </pre>
     *
     * <code>string userId = 1;</code>
     */
    public java.lang.String getUserId() {
      java.lang.Object ref = userId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     **
     * 用户id
     * </pre>
     *
     * <code>string userId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUserIdBytes() {
      java.lang.Object ref = userId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     **
     * 用户id
     * </pre>
     *
     * <code>string userId = 1;</code>
     */
    public Builder setUserId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 用户id
     * </pre>
     *
     * <code>string userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = getDefaultInstance().getUserId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 用户id
     * </pre>
     *
     * <code>string userId = 1;</code>
     */
    public Builder setUserIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object examId_ = "";
    /**
     * <pre>
     **
     * 考试的id
     * </pre>
     *
     * <code>string examId = 2;</code>
     */
    public java.lang.String getExamId() {
      java.lang.Object ref = examId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        examId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     **
     * 考试的id
     * </pre>
     *
     * <code>string examId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getExamIdBytes() {
      java.lang.Object ref = examId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        examId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     **
     * 考试的id
     * </pre>
     *
     * <code>string examId = 2;</code>
     */
    public Builder setExamId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      examId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 考试的id
     * </pre>
     *
     * <code>string examId = 2;</code>
     */
    public Builder clearExamId() {
      
      examId_ = getDefaultInstance().getExamId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 考试的id
     * </pre>
     *
     * <code>string examId = 2;</code>
     */
    public Builder setExamIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      examId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object bankId_ = "";
    /**
     * <pre>
     **
     * 考试的题库id
     * </pre>
     *
     * <code>string bankId = 3;</code>
     */
    public java.lang.String getBankId() {
      java.lang.Object ref = bankId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        bankId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     **
     * 考试的题库id
     * </pre>
     *
     * <code>string bankId = 3;</code>
     */
    public com.google.protobuf.ByteString
        getBankIdBytes() {
      java.lang.Object ref = bankId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        bankId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     **
     * 考试的题库id
     * </pre>
     *
     * <code>string bankId = 3;</code>
     */
    public Builder setBankId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      bankId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 考试的题库id
     * </pre>
     *
     * <code>string bankId = 3;</code>
     */
    public Builder clearBankId() {
      
      bankId_ = getDefaultInstance().getBankId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 考试的题库id
     * </pre>
     *
     * <code>string bankId = 3;</code>
     */
    public Builder setBankIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      bankId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object submitCode_ = "";
    /**
     * <pre>
     **
     * 提交的代码
     * </pre>
     *
     * <code>string submitCode = 5;</code>
     */
    public java.lang.String getSubmitCode() {
      java.lang.Object ref = submitCode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        submitCode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     **
     * 提交的代码
     * </pre>
     *
     * <code>string submitCode = 5;</code>
     */
    public com.google.protobuf.ByteString
        getSubmitCodeBytes() {
      java.lang.Object ref = submitCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        submitCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     **
     * 提交的代码
     * </pre>
     *
     * <code>string submitCode = 5;</code>
     */
    public Builder setSubmitCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      submitCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 提交的代码
     * </pre>
     *
     * <code>string submitCode = 5;</code>
     */
    public Builder clearSubmitCode() {
      
      submitCode_ = getDefaultInstance().getSubmitCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     **
     * 提交的代码
     * </pre>
     *
     * <code>string submitCode = 5;</code>
     */
    public Builder setSubmitCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      submitCode_ = value;
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


    // @@protoc_insertion_point(builder_scope:com.moxi.proBuf.ProSubmit)
  }

  // @@protoc_insertion_point(class_scope:com.moxi.proBuf.ProSubmit)
  private static final com.moxi.proBuf.ProSubmit DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.moxi.proBuf.ProSubmit();
  }

  public static com.moxi.proBuf.ProSubmit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProSubmit>
      PARSER = new com.google.protobuf.AbstractParser<ProSubmit>() {
    public ProSubmit parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProSubmit(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProSubmit> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProSubmit> getParserForType() {
    return PARSER;
  }

  public com.moxi.proBuf.ProSubmit getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

