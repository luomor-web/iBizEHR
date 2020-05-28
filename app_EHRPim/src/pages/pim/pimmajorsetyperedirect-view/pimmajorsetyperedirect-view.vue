<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMMAJORSETYPERedirectViewBase from './pimmajorsetyperedirect-view-base.vue';


/**
 * 专业序列类型数据重定向视图
 *
 * @export
 * @class PIMMAJORSETYPERedirectView
 * @extends {PIMMAJORSETYPERedirectViewBase}
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
export default class PIMMAJORSETYPERedirectView extends PIMMAJORSETYPERedirectViewBase { }
</script>