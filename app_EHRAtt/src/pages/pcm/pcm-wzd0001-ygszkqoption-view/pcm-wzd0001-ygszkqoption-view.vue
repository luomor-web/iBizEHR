<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmWzd0001YGSZKQOptionViewBase from './pcm-wzd0001-ygszkqoption-view-base.vue';

import view_form from '@widgets/pcm-wzd0001/ygszkq-form/ygszkq-form.vue';

/**
 * 员工设置考勤
 *
 * @export
 * @class PcmWzd0001YGSZKQOptionView
 * @extends {PcmWzd0001YGSZKQOptionViewBase}
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
export default class PcmWzd0001YGSZKQOptionView extends PcmWzd0001YGSZKQOptionViewBase { }
</script>