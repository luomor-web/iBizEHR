<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjdmxRedirectViewBase from './pcm-ydjdmx-redirect-view-base.vue';


/**
 * 异动借调明细数据重定向视图
 *
 * @export
 * @class PcmYdjdmxRedirectView
 * @extends {PcmYdjdmxRedirectViewBase}
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
export default class PcmYdjdmxRedirectView extends PcmYdjdmxRedirectViewBase { }
</script>