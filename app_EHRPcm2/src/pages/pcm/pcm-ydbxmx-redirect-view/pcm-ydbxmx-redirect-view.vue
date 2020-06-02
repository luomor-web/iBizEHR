<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdbxmxRedirectViewBase from './pcm-ydbxmx-redirect-view-base.vue';


/**
 * 异动病休明细数据重定向视图
 *
 * @export
 * @class PcmYdbxmxRedirectView
 * @extends {PcmYdbxmxRedirectViewBase}
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
export default class PcmYdbxmxRedirectView extends PcmYdbxmxRedirectViewBase { }
</script>