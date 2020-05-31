<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PCMXKMLMPickupViewBase from './pcmxkmlmpickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pcm-xkml/mpickup-viewpickupviewpanel-pickupviewpanel/mpickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 学科目录数据多项选择视图
 *
 * @export
 * @class PCMXKMLMPickupView
 * @extends {PCMXKMLMPickupViewBase}
 */
@Component({
    components: {
        view_pickupviewpanel, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class PCMXKMLMPickupView extends PCMXKMLMPickupViewBase { }
</script>