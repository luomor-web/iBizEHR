<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ARCHIVESCENTERRedirectViewBase from './archivescenterredirect-view-base.vue';


/**
 * 档案室管理数据重定向视图
 *
 * @export
 * @class ARCHIVESCENTERRedirectView
 * @extends {ARCHIVESCENTERRedirectViewBase}
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
export default class ARCHIVESCENTERRedirectView extends ARCHIVESCENTERRedirectViewBase { }
</script>