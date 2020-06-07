<template>
    <div class="upload-file">
        <upload 
          :action="url" 
          :headers="headers ? headers : null"
          :multiple="multiple === true ? true : false" 
          :paste="paste === false ? false : true"
          :disabled="disabled === true ? true : false" 
          :data="data ? data : null"
          :type="type === 'select' ? 'select' : 'drag'" 
          :show-upload-list="showuploadlist === true ? true : false"
          :accept="accept ? accept : null" 
          :format="format ? format : []"
          :maxsize="maxsize ? maxsize : null" 
          :on-before-upload="beforeupload" 
          :on-success="success"
          :on-error="error" 
          :on-remove="remove" 
          :on-format-error="formaterror"
          :on-exceeded-size="exceededsize" 
          :on-progress="progress">
            <div class="upload-text">
                <p>将图片拖到这里替换</p>
                <p><span class="text-style">本地上传</span>或<span class="text-style">从素材库选择</span></p>
            </div>
        </upload>
    </div>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator';

@Component({})
export default class UploadFile extends Vue {

    /**
     * 上传路径
     * @type {any}
     * @memberof UploadFile
     */
    public url: string = '//jsonplaceholder.typicode.com/posts/';

    /**
     * 设置上传的请求头部
     * @type {Object}
     * @memberof UploadFile
     */
    @Prop() public headers?: Object;

    /**
     * 是否支持多选文件
     * @type {boolean}
     * @memberof UploadFile
     */
    @Prop() public multiple?: boolean;

    /**
     * 是否支持粘贴上传文件
     * @type {boolean}
     * @memberof UploadFile 
     */
    @Prop() public paste?: boolean;

    /**
     * 是否禁用
     * @type {boolean}
     * @memberof UploadFile 
     */
    @Prop() public disabled?: boolean;

    /**
     * 上传时附带的额外参数
     * @type {any}
     * @memberof UploadFile 
     */
    @Prop() public data?: any;

    /**
     * 上传控件的类型，可选值为 select（点击选择），drag（支持拖拽）
     * @type {any}
     * @memberof UploadFile 
     */
    @Prop() public type?: any;

    /**
     * 是否显示已上传文件列表
     * @type {boolean}
     * @memberof UploadFile
     */
    @Prop() public showuploadlist?: boolean;

    /**
     * 接受上传的文件类型
     * @type {string}
     * @memberof UploadFile
     */
    @Prop() public accept?: string;

    /**
     * 支持的文件类型，与 accept 不同的是，format 是识别文件的后缀名，accept 为 input 标签原生的 accept 属性，
     * 会在选择文件时过滤，可以两者结合使用
     * @type {Array<any>}
     * @memberof UploadFile
     */
    @Prop() public format?: Array<any>;

    /**
     * 文件大小限制，单位 kb
     * @type {number}
     * @memberof UploadFile
     */
    @Prop() public maxsize?: number;

    /**
     * 上传文件之前的钩子，参数为上传的文件，若返回 false 或者 Promise 则停止上传
     */
    @Emit()
    public beforeupload(file:any) {
        console.log('beforeupload---------'+file);
    }

    /**
     * 文件上传成功时的钩子，返回字段为 response, file, fileList
     */
    @Emit()
    public success(response: any, file: any, fileList: any) {
        console.log('success---------' + file);
    }

    /**
     * 文件上传时的钩子，返回字段为 event, file, fileList
     */
    @Emit()
    public progress(event: any, file: any, fileList: any) {
        console.log('progress---------' + file);
    }

    /**
     * 文件上传失败时的钩子，返回字段为 error, file, fileList
     */
    @Emit()
    public error(error: any, file: any, fileList: any) {
        console.log('error---------' + file);
    }

    /**
     * 文件列表移除文件时的钩子，返回字段为 file, fileList
     */
    @Emit()
    public remove(file: any, fileList: any) {
        console.log('remove---------' + file);
    }

    /**
     * 文件格式验证失败时的钩子，返回字段为 file, fileList
     */
    @Emit()
    public formaterror(file: any, fileList: any) {
        console.log('formaterror---------' + file);
    }

    /**
     * 文件超出指定大小限制时的钩子，返回字段为 file, fileList
     */
    @Emit()
    public exceededsize(file: any, fileList: any) {
        console.log('exceededsize---------' + file);
    }

}
</script>

<style lang='less'>
@import './upload-file.less';
</style>