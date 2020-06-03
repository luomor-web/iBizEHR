<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdtxmxRedirectViewBase from './pcm-ydtxmx-redirect-view-base.vue';


/**
 * 异动病休明细数据重定向视图
 *
 * @export
 * @class PcmYdtxmxRedirectView
 * @extends {PcmYdtxmxRedirectViewBase}
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
export default class PcmYdtxmxRedirectView extends PcmYdtxmxRedirectViewBase { }
</script>