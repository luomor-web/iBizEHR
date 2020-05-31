<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMGWTYPERedirectViewBase from './pimgwtyperedirect-view-base.vue';


/**
 * 岗位类型对照表数据重定向视图
 *
 * @export
 * @class PIMGWTYPERedirectView
 * @extends {PIMGWTYPERedirectViewBase}
 */
@Component({
    components: {
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PIMGWTYPERedirectView extends PIMGWTYPERedirectViewBase { }
</script>