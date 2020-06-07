<template>
  <div class='app-picture-preview'>
    <ul class="">
      <li v-for="(file,index) in files" :key="index" class="preview-file-list-item">
        <div class='preview-file-list-img'>
          <el-image :src="file.url" class='' style=''>
              <div slot='error' class='image-slot'>
                  <img src="/assets/img/picture.png" style='width:100%;height:100%;'>
              </div>
          </el-image>
          <div class='preview-file-list-actions'>
              <span class='action-preview'>
                  <i class='el-icon-zoom-in' @click="onPreview(file)"></i>
              </span>
              <span class='action-download'>
                  <i class='el-icon-download' @click="onDownload(file)"></i>
              </span>
          </div>
        </div>
      </li>
    </ul>
    <!-- 预览 -->
    <modal v-model="dialogVisible" footer-hide width="auto" class-name='app-image-preview-model'>
      <el-image src="dialogImageUrl">
          <div slot='error' class='image-slot'>
              <img src="/assets/img/picture.png">
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
export default class AppImagePreview extends Vue {

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppImagePreview
     */
    @Prop() public formState?: Subject<any>


    /**
     * 表单状态事件
     *
     * @private
     * @type {(Unsubscribable | undefined)}
     * @memberof AppImagePreview
     */
    private formStateEvent: Unsubscribable | undefined;

    /**
     * 初始化值
     *
     * @type {*}
     * @memberof AppImagePreview
     */
    @Prop() public value?: any;

    /**
     * 数据值变化
     *
     * @param {*} newval
     * @param {*} val
     * @returns
     * @memberof AppImagePreview
     */
    @Watch('value')
    onValueChange(newval: any, val: any) {
        this.setFiles(newval)
    }

    /**
     * 所属表单项名称
     *
     * @type {string}
     * @memberof AppImagePreview
     */
    @Prop() public name!: string;

    /**
     * 上传文件路径
     *
     * @memberof AppImagePreview
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载文件路径
     *
     * @memberof AppImagePreview
     */
    public downloadUrl = Environment.BaseUrl + Environment.ExportFile;

    /**
     * 文件列表
     *
     * @memberof AppImagePreview
     */
    @Provide() public files = [];

    /**
     * 设置files
     *
     * @private
     * @memberof AppImagePreview
     */
    private setFiles(value:any): void {
        let _files = JSON.parse(value);
        if (value && Object.prototype.toString.call(_files)=='[object Array]') {
            this.files = _files;
            this.files.forEach((file: any) => {
            let url = `${this.downloadUrl}/${file.id}`;
            file.url = url;
        });
        } else {
            this.files = [];
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImagePreview
     */
    public created() {
        if (this.formState) {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    this.setFiles(this.value);
                }
            });
        }
    }

    /**
     * vue 生命周期
     *
     * @memberof AppImagePreview
     */
    public mounted() {
        this.setFiles(this.value);
    }

    /**
     * 组件销毁
     *
     * @memberof AppImagePreview
     */
    public destroyed(): void {
        if (this.formStateEvent) {
            this.formStateEvent.unsubscribe();
        }
    }

    /**
     * 下载文件
     *
     * @param {*} file
     * @memberof AppImagePreview
     */
    public onDownload(file: any) {
        window.open(file.url);
    }

    /**
     * 预览图片地址
     *
     * @type {string}
     * @memberof AppImagePreview
     */
    public dialogImageUrl: string = '';

    /**
     * 是否显示预览界面
     *
     * @type {boolean}
     * @memberof AppImagePreview
     */
    public dialogVisible: boolean = false;

    /**
     * 预览
     *
     * @param {*} file
     * @memberof AppImagePreview
     */
    public onPreview(file: any) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
    }

}
</script>
<style lang = "less">
@import './app-image-preview.less';
</style>