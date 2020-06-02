<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdntmxRedirectViewBase from './pcm-ydntmx-redirect-view-base.vue';


/**
 * 异动内退明细数据重定向视图
 *
 * @export
 * @class PcmYdntmxRedirectView
 * @extends {PcmYdntmxRedirectViewBase}
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
export default class PcmYdntmxRedirectView extends PcmYdntmxRedirectViewBase { }
</script>