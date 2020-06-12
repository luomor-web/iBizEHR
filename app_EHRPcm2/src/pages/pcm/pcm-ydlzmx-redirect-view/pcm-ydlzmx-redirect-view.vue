<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdlzmxRedirectViewBase from './pcm-ydlzmx-redirect-view-base.vue';


/**
 * 异动离职明细数据重定向视图
 *
 * @export
 * @class PcmYdlzmxRedirectView
 * @extends {PcmYdlzmxRedirectViewBase}
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
export default class PcmYdlzmxRedirectView extends PcmYdlzmxRedirectViewBase { }
</script>