<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import VACLEAVEMANAGEWFProxyStartViewBase from './vacleavemanagewfproxy-start-view-base.vue';


/**
 * 流程启动
 *
 * @export
 * @class VACLEAVEMANAGEWFProxyStartView
 * @extends {VACLEAVEMANAGEWFProxyStartViewBase}
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
export default class VACLEAVEMANAGEWFProxyStartView extends VACLEAVEMANAGEWFProxyStartViewBase { }
</script>