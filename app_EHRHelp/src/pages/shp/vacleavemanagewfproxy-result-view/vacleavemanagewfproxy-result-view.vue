<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEWFProxyResultViewBase from './vacleavemanagewfproxy-result-view-base.vue';


/**
 * 请假管理
 *
 * @export
 * @class VACLEAVEMANAGEWFProxyResultView
 * @extends {VACLEAVEMANAGEWFProxyResultViewBase}
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
export default class VACLEAVEMANAGEWFProxyResultView extends VACLEAVEMANAGEWFProxyResultViewBase { }
</script>