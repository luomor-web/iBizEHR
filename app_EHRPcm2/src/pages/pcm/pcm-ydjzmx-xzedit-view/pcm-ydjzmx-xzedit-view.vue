<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PcmYdjzmxXZEditViewBase from './pcm-ydjzmx-xzedit-view-base.vue';

import view_form from '@widgets/pcm-ydjzmx/xzjzedit-form-form/xzjzedit-form-form.vue';

/**
 * 新增兼职
 *
 * @export
 * @class PcmYdjzmxXZEditView
 * @extends {PcmYdjzmxXZEditViewBase}
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
export default class PcmYdjzmxXZEditView extends PcmYdjzmxXZEditViewBase { }
</script>