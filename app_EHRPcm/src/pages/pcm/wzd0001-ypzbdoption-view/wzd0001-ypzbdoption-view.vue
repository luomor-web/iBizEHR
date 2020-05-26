<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import WZD0001YPZBDOptionViewBase from './wzd0001-ypzbdoption-view-base.vue';

import view_form from '@widgets/wzd0001/ypzbd-form/ypzbd-form.vue';

/**
 * 报到
 *
 * @export
 * @class WZD0001YPZBDOptionView
 * @extends {WZD0001YPZBDOptionViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class WZD0001YPZBDOptionView extends WZD0001YPZBDOptionViewBase { }
</script>