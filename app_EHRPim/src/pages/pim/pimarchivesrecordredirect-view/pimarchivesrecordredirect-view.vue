<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMARCHIVESRECORDRedirectViewBase from './pimarchivesrecordredirect-view-base.vue';


/**
 * 档案目录缺失记录数据重定向视图
 *
 * @export
 * @class PIMARCHIVESRECORDRedirectView
 * @extends {PIMARCHIVESRECORDRedirectViewBase}
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
export default class PIMARCHIVESRECORDRedirectView extends PIMARCHIVESRECORDRedirectViewBase { }
</script>