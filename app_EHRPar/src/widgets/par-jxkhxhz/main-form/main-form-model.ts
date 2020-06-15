/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        prop: 'parjxkhxhzid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parjxkhxhzname',
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
        name: 'ygid',
        prop: 'ygid',
        dataType: 'TEXT',
      },
      {
        name: 'xh',
        prop: 'xh',
        dataType: 'INT',
      },
      {
        name: 'yg',
        prop: 'yg',
        dataType: 'TEXT',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'TEXT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'TEXT',
      },
      {
        name: 'parassesstemplatename',
        prop: 'parassesstemplatename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parjxkhxhzid',
        prop: 'parjxkhxhzid',
        dataType: 'GUID',
      },
      {
        name: 'parassesstemplateid',
        prop: 'parassesstemplateid',
        dataType: 'PICKUP',
      },
      {
        name: 'parjxkhxhz',
        prop: 'parjxkhxhzid',
        dataType: 'FONTKEY',
      },
    ]
  }

}