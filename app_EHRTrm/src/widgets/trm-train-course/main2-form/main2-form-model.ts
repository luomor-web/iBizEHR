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
        prop: 'trmtraincourseid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmtraincoursename',
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
        name: 'trmtraincoursename',
        prop: 'trmtraincoursename',
        dataType: 'TEXT',
      },
      {
        name: 'trmcoursesystemname',
        prop: 'trmcoursesystemname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jb',
        prop: 'jb',
        dataType: 'TEXT',
      },
      {
        name: 'bb',
        prop: 'bb',
        dataType: 'TEXT',
      },
      {
        name: 'kcxs',
        prop: 'kcxs',
        dataType: 'FLOAT',
      },
      {
        name: 'pxmb',
        prop: 'pxmb',
        dataType: 'TEXT',
      },
      {
        name: 'nr',
        prop: 'nr',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'sfgx',
        prop: 'sfgx',
        dataType: 'YESNO',
      },
      {
        name: 'kcjs',
        prop: 'kcjs',
        dataType: 'TEXT',
      },
      {
        name: 'trmcoursesystemid',
        prop: 'trmcoursesystemid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtraincourseid',
        prop: 'trmtraincourseid',
        dataType: 'GUID',
      },
      {
        name: 'trmtraincourse',
        prop: 'trmtraincourseid',
        dataType: 'FONTKEY',
      },
    ]
  }

}