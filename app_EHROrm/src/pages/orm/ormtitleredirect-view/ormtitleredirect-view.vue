<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMTITLERedirectViewBase from './ormtitleredirect-view-base.vue';


/**
 * 头衔管理数据重定向视图
 *
 * @export
 * @class ORMTITLERedirectView
 * @extends {ORMTITLERedirectViewBase}
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
export default class ORMTITLERedirectView extends ORMTITLERedirectViewBase { }
</script>