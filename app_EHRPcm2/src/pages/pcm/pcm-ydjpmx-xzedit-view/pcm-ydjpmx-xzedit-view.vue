<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjpmxXZEditViewBase from './pcm-ydjpmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-ydjpmx/main-form/main-form.vue';

/**
 * 新增解聘
 *
 * @export
 * @class PcmYdjpmxXZEditView
 * @extends {PcmYdjpmxXZEditViewBase}
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
export default class PcmYdjpmxXZEditView extends PcmYdjpmxXZEditViewBase { }
</script>