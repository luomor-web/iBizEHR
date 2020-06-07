<template>
  <div class='app-picture-upload'>
    <ul class='el-upload-list el-upload-list--picture-card'>
<!-- 绘制缩略图 Start -->
        <li v-for="(file,index) in files" :key="index" class='el-upload-list__item is-success'>
          <el-image :src="file.url" class='el-upload-list__item-thumbnail' style='min-height:100px;min-width:100px;'>
              <div slot='error' class='image-slot'>
                  <i class='el-icon-picture-outline'></i>
              </div>
          </el-image>
          <a class='el-upload-list__item-name'>
              <i class='el-icon-document'></i> {{file.name}}
          </a>
          <i class='el-icon-close'></i>
          <label class='el-upload-list__item-status-label'>
              <i class='el-icon-upload-success el-icon-check'></i>
          </label>
          <span class='el-upload-list__item-actions'>
              <span class='el-upload-list__item-preview'>
                  <i class='el-icon-zoom-in' @click="onPreview(file)"></i>
              </span>
              <span class='el-upload-list__item-download'>
                  <i class='el-icon-download' @click="onDownload(file)"></i>
              </span>
              <span :style="{ 'display': disabled? 'none' : 'inline-block' }" class='el-upload-list__item-delete'>
                  <i class='el-icon-delete' @click="onRemove(file, files)"></i>
              </span>
          </span>
        </li>
            <!-- 绘制缩略图 end -->
    </ul>
    <!-- 文件上传 -->
    <el-upload 
      v-if = "multiple || files.length === 0" 
      :class = "{'el-upload-disabled':disabled}"
      :disabled = "disabled"
      :action = "uploadUrl"
      :headers = "{ 'srfappdata': appData }"
      :show-file-list = "false"
      list-type =  "picture-card"
      :file-list =  "files"
      :before-upload = "beforeUpload"
      :on-success = "onSuccess"
      :before-remove = "onRemove"
      :on-error = "onError"
      :on-preview = "onDownload"
      >
      <i class="el-icon-plus"></i>
    </el-upload>
    <!-- 预览 -->
    <modal v-model="dialogVisible" footer-hide class-name='app-image-upload-model'>
      <el-image src="dialogImageUrl">
          <div slot='error' class='image-slot'>
              <i class='el-icon-picture-outline'></i>
          </div>
      </el-image>
    </modal>
  </div>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Watch, Provide } from 'vue-property-decorator';
import { Environment } from '@/environments/environment';
import { Subject, Unsubscribable } from 'rxjs';

@Component({})
export default class AppImageUpload extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppImageUpload
     */
    @Prop() public formState?: Subject<any>

    /**
     * 是否忽略表单项书香值变化
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop() public ignorefieldvaluechange?: boolean;

    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppImageUpload
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * 表单数据
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public data!: string;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @returns
     * @memberof AppImageUpload
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        if (this.ignorefieldvaluechange) {
            return;
        }
        this.setFiles(newval)
        this.dataProcess();
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public name!: string;

    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop() public disabled?: boolean;

    /**
     * 上传参数
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public uploadparams?: string;

    /**
     * 下载参数
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    @Prop() public exportparams?: string;

    /**
     * 自定义参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    @Prop() public customparams?: any;

    /**
     * 上传文件路径
     *
     * @memberof AppImageUpload
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppImageUpload
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppImageUpload
     */
    @Provide() public files = [];

    /**
     * 上传keys
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public upload_keys: Array<any> = [];

    /**
     * 导出keys
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public export_keys: Array<any> = [];

    /**
     * 自定义数组
     *
     * @type {Array<any>}
     * @memberof AppImageUpload
     */
    public custom_arr: Array<any> = [];

    /**
     * 应用参数
     *
     * @type {*}
     * @memberof AppImageUpload
     */
    public appData: any="";

    /**
     * 设置files
     *
     * @private
     * @memberof AppImageUpload
     */
    private setFiles(value:any): void {
        let _files = JSON.parse(value);
        if (value && Object.prototype.toString.call(_files)=='[object Array]') {
            this.files = _files;
        } else {
            this.files = [];
        }
    }

    /**
     * 数据处理
     *
     * @private
     * @memberof AppImageUpload
     */
    private dataProcess(): void {
        let upload_arr: Array<string> = [];
        let export_arr: Array<string> = [];
        const _data: any = JSON.parse(this.data);
        this.upload_keys.forEach((key: string) => {
            upload_arr.push(`${key}=${_data[key]}`);
        });
        this.export_keys.forEach((key: string) => {
            export_arr.push(`${key}=${_data[key]}`);
        });

        let _url = `${Environment.BaseUrl}${Environment.UploadFile}`;
        if (upload_arr.length > 0 || this.custom_arr.length > 0) {
            _url = `${_url}?${upload_arr.join('&')}${upload_arr.length > 0 ? '&' : ''}${this.custom_arr.join('&')}`;
        }
        this.uploadUrl = _url;

        this.files.forEach((file: any) => {
            let url = `${this.downloadUrl}/${file.id}`;
            if (upload_arr.length > 0 || this.custom_arr.length > 0) {
                url = `${url}?${upload_arr.join('&')}${upload_arr.length > 0 ? '&' : ''}${this.custom_arr.join('&')}`;
            }
            file.url = url;
        });
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImageUpload
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    this.setFiles(this.value);
                    this.dataProcess();
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImageUpload
     */
    public mounted() {
        this.appData = this.$store.getters.getAppData();

        let uploadparams: string = '';
        let exportparams: string = '';

        let upload_keys: Array<string> = [];
        let export_keys: Array<string> = [];
        let custom_arr: Array<string> = [];
        if (this.uploadparams && !Object.is(this.uploadparams, '')) {
            uploadparams = this.uploadparams;
            upload_keys = uploadparams.split(';');
        }
        if (this.exportparams && !Object.is(this.exportparams, '')) {
            exportparams = this.exportparams;
            export_keys = exportparams.split(';');
        }
        if (this.customparams && !Object.is(this.customparams, '')) {
            Object.keys(this.customparams).forEach((name: string) => {
                custom_arr.push(`${name}=${this.customparams[name]}`);
            });
        }
        this.upload_keys = upload_keys;
        this.export_keys = export_keys;
        this.custom_arr = custom_arr;

        this.setFiles(this.value);
        this.dataProcess();
    }

    /**
     * 组件销毁
     *
     * @memberof AppImageUpload
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 上传之前
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public beforeUpload(file: any) {
        // console.log('上传之前');
    }

    /**
     * 上传成功回调
     *
     * @param {*} response
     * @param {*} file
     * @param {*} fileList
     * @returns
     * @memberof AppImageUpload
     */
    public onSuccess(response: any, file: any, fileList: any) {
        if (!response) {
            return;
        }
        const data = { name: response.filename, id: response.fileid };
        let arr: Array<any> = [];
        this.files.forEach((_file: any) => {
            arr.push({ name: _file.name, id: _file.id })
        });
        arr.push(data);

        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 上传失败回调
     *
     * @param {*} error
     * @param {*} file
     * @param {*} fileList
     * @memberof AppImageUpload
     */
    public onError(error: any, file: any, fileList: any) {
        this.$Notice.error({ title: '上传失败' });
    }

    /**
     * 删除文件
     *
     * @param {*} file
     * @param {*} fileList
     * @memberof AppImageUpload
     */
    public onRemove(file: any, fileList: any) {
        let arr: Array<any> = [];
        fileList.forEach((f: any) => {
            if (f.id != file.id) {
                arr.push({ name: f.name, id: f.id });
            }
        });
        let value: any = arr.length > 0 ? JSON.stringify(arr) : null;
        this.$emit('formitemvaluechange', { name: this.name, value: value });
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public onDownload(file: any) {
        window.open(file.url);
    }

    /**
     * 预览图片地址
     *
     * @type {string}
     * @memberof AppImageUpload
     */
    public dialogImageUrl: string = '';

    /**
     * 是否显示预览界面
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    public dialogVisible: boolean = false;

    /**
     * 是否支持多个上传
     *
     * @type {boolean}
     * @memberof AppImageUpload
     */
    @Prop({ default: true }) public multiple?: boolean;

    /**
     * 预览
     *
     * @param {*} file
     * @memberof AppImageUpload
     */
    public onPreview(file: any) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
    }
}
</script>
<style lang = "less">
@import './app-image-upload.less';
</style>