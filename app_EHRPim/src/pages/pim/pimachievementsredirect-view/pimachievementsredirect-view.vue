<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMACHIEVEMENTSRedirectViewBase from './pimachievementsredirect-view-base.vue';


/**
 * 绩效信息数据重定向视图
 *
 * @export
 * @class PIMACHIEVEMENTSRedirectView
 * @extends {PIMACHIEVEMENTSRedirectViewBase}
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
export default class PIMACHIEVEMENTSRedirectView extends PIMACHIEVEMENTSRedirectViewBase { }
</script>