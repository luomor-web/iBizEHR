<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMMAJORSETYPEPickupViewBase from './pimmajorsetypepickup-view-base.vue';

import view_pickupviewpanel from '@widgets/pimmajorsetype/pickup-viewpickupviewpanel-pickupviewpanel/pickup-viewpickupviewpanel-pickupviewpanel.vue';

/**
 * 专业序列类型数据选择视图
 *
 * @export
 * @class PIMMAJORSETYPEPickupView
 * @extends {PIMMAJORSETYPEPickupViewBase}
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
export default class PIMMAJORSETYPEPickupView extends PIMMAJORSETYPEPickupViewBase { }
</script>