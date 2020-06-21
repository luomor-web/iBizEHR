/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'parassesstemplateid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parassesstemplatename',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'parassesstemplatename',
        prop: 'parassesstemplatename',
        dataType: 'TEXT',
      },
      {
        name: 'khdx',
        prop: 'khdx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'sfyx',
        prop: 'sfyx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parassesstemplateid',
        prop: 'parassesstemplateid',
        dataType: 'GUID',
      },
      {
        name: 'parassesstemplate',
        prop: 'parassesstemplateid',
        dataType: 'FONTKEY',
      },
    ]
  }

}